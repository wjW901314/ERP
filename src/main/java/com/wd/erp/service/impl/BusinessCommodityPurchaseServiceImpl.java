package com.wd.erp.service.impl;

import com.wd.erp.mapper.BusinessCommodityPurchaseMapper;
import com.wd.erp.model.BusinessCommodityPurchase;
import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BusinessCommodityPurchaseService;
import com.wd.erp.service.BusinessCommodityStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

/**
 * 商品进货服务
 */
@Service
public class BusinessCommodityPurchaseServiceImpl implements BusinessCommodityPurchaseService {
    @Autowired
    BusinessCommodityPurchaseMapper commodityPurchaseMapper;

    @Resource
    BusinessCommodityStockService commodityStockService;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<BusinessCommodityPurchase> list = commodityPurchaseMapper.getAll(keyWord);
        if(list != null){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson addCommodityPurchase(BusinessCommodityPurchase record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = commodityPurchaseMapper.getMaxCode() + 1;
        record.setId(format("%010d",maxCode));
        record.setPurchaseDate(new Date());
        record.setStatus(0);
        int i = commodityPurchaseMapper.insert(record);
        if(i > 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyCommodityPurchase(BusinessCommodityPurchase record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if(StringUtils.isEmpty(record.getId())){
            resultJson.setMsg("ID不能为空!");
            return resultJson;
        }
        int i = commodityPurchaseMapper.updateByPrimaryKey(record);
        if(i > 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteCommodityPurchase(String purchaseCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if(StringUtils.isEmpty(purchaseCode)){
            resultJson.setMsg("ID不能为空!");
            return resultJson;
        }
        int i = commodityPurchaseMapper.deleteByPrimaryKey(purchaseCode);
        if(i > 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson auditVoidRecord(String id,String status) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg(status.equals("0") ? "审核失败!" : "作废失败!");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("ID不能为空!");
            return resultJson;
        }
        int i = commodityPurchaseMapper.auditVoidRecord(id,status);
        if(i > 0){
            if(status.equals("1")){
                BusinessCommodityPurchase purchase = commodityPurchaseMapper.selectByPrimaryKey(id);
                if(purchase != null){
                    BusinessCommodityStock stock = new BusinessCommodityStock();
                    stock.setCommodityCode(purchase.getCommodityCode());
                    stock.setInventory(purchase.getPurchaseNumber());
                    stock.setSmallUnit(purchase.getUnitCode());
                    stock.setLargeUnit(purchase.getUnitCode());
                    stock.setPrice(purchase.getPurchasePrice());
                    stock.setMinimumInventory(10);
                    stock.setTotalPrice(purchase.getPurchaseNumber() * purchase.getPurchasePrice());
                    if(!commodityStockService.addStock(stock).getSuccess()){
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                }
            }
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg(status.equals("1") ? "审核成功!" : "作废成功!");
        }
        return resultJson;
    }
}
