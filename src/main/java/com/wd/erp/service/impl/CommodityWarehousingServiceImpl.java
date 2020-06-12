package com.wd.erp.service.impl;

import com.wd.erp.mapper.CommodityWarehousingMapper;
import com.wd.erp.model.CommodityWarehousing;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityWarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/*
商品入库Service
 */
@Service
public class CommodityWarehousingServiceImpl implements CommodityWarehousingService {
    @Autowired
    CommodityWarehousingMapper warehousingMapper;

    /*
    添加商品库存
     */
    @Override
    public ResultJson addStock(CommodityWarehousing record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg("添加失败!");
        resultJson.setSuccess(false);
        int i = warehousingMapper.insert(record);
        if (i == 1) {
            resultJson.setMsg("添加成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteStock(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg("删除失败!");
        resultJson.setSuccess(false);
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("id不能为空！");
            return resultJson;
        }
        int i = warehousingMapper.deleteByPrimaryKey(id);
        if(i == 1){
            resultJson.setMsg("删除成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("id不能为空！");
            return resultJson;
        }
        CommodityWarehousing commodityWarehousing = warehousingMapper.selectByPrimaryKey(id);
        if(commodityWarehousing == null){
            resultJson.setMsg("未找到此"+id+"的库存数据!");
            resultJson.setSuccess(true);
        }else{
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<CommodityWarehousing> list = warehousingMapper.getAll();
        if(list.size() >= 0){
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyStockById(CommodityWarehousing record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg("修改失败!");
        resultJson.setSuccess(false);
        if(StringUtils.isEmpty(record.getId())){
            resultJson.setSuccess(false);
            resultJson.setMsg("id不能为空!");
        }
        int i = warehousingMapper.updateByPrimaryKey(record);
        if(i == 1){
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }
}
