package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubCommodityInfoMapper;
import com.wd.erp.model.PubCommodityInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubCommodityInfoServiceImpl implements PubCommodityInfoService {
    @Autowired
    PubCommodityInfoMapper commodityInfoMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubCommodityInfo> list = commodityInfoMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String commodityCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(commodityCode)) {
            resultJson.setMsg("商品编码不能为空!");
            return resultJson;
        }
        PubCommodityInfo commodityInfo = commodityInfoMapper.getById(commodityCode);
        if (commodityInfo != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功");
            resultJson.setData(commodityInfo);
        }
        return resultJson;
    }

    @Override
    public ResultJson addCommodity(PubCommodityInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = commodityInfoMapper.getMaxCode() + 1;
        record.setCommodityCode(format("%010d",maxCode));
        int i = commodityInfoMapper.insert(record);
        if(i > 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyCommodity(PubCommodityInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if (StringUtils.isEmpty(record.getCommodityCode())) {
            resultJson.setMsg("商品编码不能为空!");
            return resultJson;
        }
        int i = commodityInfoMapper.updateByPrimaryKeyWithBLOBs(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteCommodity(String commodityCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if (StringUtils.isEmpty(commodityCode)) {
            resultJson.setMsg("商品编码不能为空!");
            return resultJson;
        }
        int i = commodityInfoMapper.deleteByPrimaryKey(commodityCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功");
        }
        return resultJson;
    }
}
