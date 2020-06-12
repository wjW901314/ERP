package com.wd.erp.service.impl;

import com.wd.erp.mapper.CommodityOutboundMapper;
import com.wd.erp.model.CommodityOutbound;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CommodityOutboundServiceImpl implements CommodityOutboundService {

    @Autowired
    CommodityOutboundMapper outboundMapper;

    @Override
    public ResultJson addOutStock(CommodityOutbound commodityOutbound) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg("添加失败!");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(commodityOutbound.getCommodityId())) {
            resultJson.setSuccess(false);
            resultJson.setMsg("商品ID不能为空");
            return resultJson;
        }
        int i = outboundMapper.insert(commodityOutbound);
        if (i == 1) {
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteOutStock(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("id不能为空！");
            resultJson.setSuccess(false);
            return resultJson;
        }
        int i = outboundMapper.deleteByPrimaryKey(id);
        if(i == 1){
            resultJson.setMsg("删除成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyOutStock(CommodityOutbound commodityOutbound) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败");
        if(StringUtils.isEmpty(commodityOutbound.getId())){
            resultJson.setMsg("ID不能为空");
            resultJson.setSuccess(false);
            return resultJson;
        }
        int i = outboundMapper.updateByPrimaryKey(commodityOutbound);
        if(i == 1){
            resultJson.setMsg("修改成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败！");
        List<CommodityOutbound> list = outboundMapper.getAll();
        if(list.size() >= 0){
            resultJson.setMsg("查询成功！");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson getOne(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败！");
        CommodityOutbound model = outboundMapper.selectByPrimaryKey(id);
        if(model != null){
            resultJson.setMsg("查询成功！");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }
}
