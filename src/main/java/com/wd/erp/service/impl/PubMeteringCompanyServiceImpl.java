package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubMeteringCompanyMapper;
import com.wd.erp.model.PubMeteringCompany;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubMeteringCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubMeteringCompanyServiceImpl implements PubMeteringCompanyService {
    @Autowired
    PubMeteringCompanyMapper meteringCompanyMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubMeteringCompany> list = meteringCompanyMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String unitCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(unitCode)) {
            resultJson.setMsg("计量单位编码不能为空!");
            return resultJson;
        }
        PubMeteringCompany meteringCompany = meteringCompanyMapper.getById(unitCode);
        if (meteringCompany != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(meteringCompany);
        }
        return resultJson;
    }

    @Override
    public ResultJson addMetering(PubMeteringCompany record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = meteringCompanyMapper.getMaxCode() + 1;
        record.setUnitCode(format("%05d", maxCode));
        int i = meteringCompanyMapper.insert(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyMetering(PubMeteringCompany record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if (StringUtils.isEmpty(record.getUnitCode())) {
            resultJson.setMsg("计量单位编码不能为空!");
            return resultJson;
        }
        int i = meteringCompanyMapper.updateByPrimaryKey(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteMetering(String unitCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if (StringUtils.isEmpty(unitCode)) {
            resultJson.setMsg("计量单位编码不能为空!");
            return resultJson;
        }
        int i = meteringCompanyMapper.deleteByPrimaryKey(unitCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }
}
