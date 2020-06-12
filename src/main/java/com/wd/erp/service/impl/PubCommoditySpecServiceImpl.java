package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubCommoditySpecMapper;
import com.wd.erp.model.PubCommoditySpec;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommoditySpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubCommoditySpecServiceImpl implements PubCommoditySpecService {
    @Autowired
    PubCommoditySpecMapper commoditySpecMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubCommoditySpec> list = commoditySpecMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String specCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(specCode)) {
            resultJson.setMsg("规格编码不能为空!");
            return resultJson;
        }
        PubCommoditySpec commoditySpec = commoditySpecMapper.getById(specCode);
        if (commoditySpec != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(commoditySpec);
        }
        return resultJson;
    }

    @Override
    public ResultJson addSpec(PubCommoditySpec record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = commoditySpecMapper.getMaxCode();
        record.setSpecCode(format("%05d", maxCode));
        int i = commoditySpecMapper.insert(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifySpec(PubCommoditySpec record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if (StringUtils.isEmpty(record.getSpecCode())) {
            resultJson.setMsg("规格编码不能为空!");
            return resultJson;
        }
        int i = commoditySpecMapper.updateByPrimaryKey(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteSpec(String specCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if (StringUtils.isEmpty(specCode)) {
            resultJson.setMsg("规格编码不能为空!");
            return resultJson;
        }
        int i = commoditySpecMapper.deleteByPrimaryKey(specCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }
}
