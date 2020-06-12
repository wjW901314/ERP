package com.wd.erp.service.impl;

import com.wd.erp.mapper.BusinessCommodityStockMapper;
import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.BusinessCommodityStockVo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BusinessCommodityStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class BusinessCommodityStockServiceImpl implements BusinessCommodityStockService {
    @Autowired
    BusinessCommodityStockMapper businessCommodityStockMapper;

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<BusinessCommodityStockVo> list = businessCommodityStockMapper.getAll();
        if (list != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("id不能为空!");
            return resultJson;
        }
        BusinessCommodityStock businessCommodityStock = businessCommodityStockMapper.selectByPrimaryKey(id);
        if (businessCommodityStock != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(businessCommodityStock);
        }
        return resultJson;
    }

    @Override
    public ResultJson fuzzyStockRecord(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<BusinessCommodityStockVo> list = businessCommodityStockMapper.fuzzyStockRecord(keyWord);
        if (list != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson addStock(BusinessCommodityStock record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = businessCommodityStockMapper.getMaxCode() + 1;
        record.setId(format("%010d",maxCode));
        int i =  businessCommodityStockMapper.insert(record);
        if (i > 0) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyStock(BusinessCommodityStock record) {
        return null;
    }

    @Override
    public ResultJson deleteStock(String id) {
        return null;
    }
}
