package com.wd.erp.service.impl;

import com.wd.erp.mapper.CommodityManagementMapper;
import com.wd.erp.model.CommodityManagement;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class CommodityManagementServiceImpl implements CommodityManagementService {

    @Autowired
    CommodityManagementMapper commodityManagementMapper;

    @Override
    public ResultJson addCommodity(CommodityManagement commodityManagement) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("添加商品失败！");
        Integer id = commodityManagementMapper.getMaxId() + 1;
        String strId = format("%5d", id);
        commodityManagement.setId(strId);
        int i = commodityManagementMapper.insert(commodityManagement);
        if (i == 1) {
            resultJson.setSuccess(true);
            resultJson.setMsg("添加商品成功！");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteByPrimaryKey(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("删除商品失败！");
        if (StringUtils.isEmpty(id)) {
            resultJson.setMsg("商品ID不能为空!");
            return resultJson;
        }
        int i = commodityManagementMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            resultJson.setSuccess(true);
            resultJson.setMsg("删除商品成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyCommodity(CommodityManagement commodityManagement) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("修改商品失败！");
        if(StringUtils.isEmpty(commodityManagement.getId())){
            resultJson.setMsg("商品ID不能为空！");
            return resultJson;
        }
        int i = commodityManagementMapper.updateByPrimaryKey(commodityManagement);
        if(i == 1){
            resultJson.setMsg("商品修改成功！");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询所有商品失败！");
        List<CommodityManagement> list = commodityManagementMapper.getAll();
        if(list.size() >= 0){
            resultJson.setSuccess(true);
            resultJson.setMsg("查询所有商品成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询单个商品失败！");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("商品ID不能为空！");
            return resultJson;
        }
        CommodityManagement commodityManagement = commodityManagementMapper.getOne(id);
        if(commodityManagement != null){
            resultJson.setSuccess(true);
            resultJson.setMsg("查询所有商品成功!");
            resultJson.setData(commodityManagement);
        }
        return resultJson;
    }
}
