package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubCommodityTypeMapper;
import com.wd.erp.model.PubCommodityType;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubCommodityTypeServiceImpl implements PubCommodityTypeService {
    @Autowired
    PubCommodityTypeMapper commodityTypeMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubCommodityType> list = commodityTypeMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setMsg("查询成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String typeCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(typeCode)) {
            resultJson.setMsg("类型编码不能为空！");
            return resultJson;
        }
        PubCommodityType commodityType = commodityTypeMapper.selectByPrimaryKey(typeCode);
        if (commodityType != null) {
            resultJson.setMsg("查询成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setData(commodityType);
        }
        return resultJson;

    }

    @Override
    public ResultJson addCommodityType(PubCommodityType record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = commodityTypeMapper.getMaxCode() + 1;
        record.setTypeCode(format("%05d", maxCode));
        int i = commodityTypeMapper.insert(record);
        if (i > 0) {
            resultJson.setMsg("添加成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyCommodityType(PubCommodityType record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if (StringUtils.isEmpty(record.getTypeCode())) {
            resultJson.setMsg("类型编码不能为空!");
            return resultJson;
        }
        int i = commodityTypeMapper.updateByPrimaryKey(record);
        if (i > 0) {
            resultJson.setMsg("修改成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteCommodityType(String typeCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if (StringUtils.isEmpty(typeCode)) {
            resultJson.setMsg("类型编码不能为空！");
            return resultJson;
        }
        int i = commodityTypeMapper.deleteByPrimaryKey(typeCode);
        if (i > 0) {
            resultJson.setMsg("删除成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
        }
        return resultJson;
    }
}
