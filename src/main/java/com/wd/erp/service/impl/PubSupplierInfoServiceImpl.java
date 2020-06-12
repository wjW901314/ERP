package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubSupplierInfoMapper;
import com.wd.erp.model.PubSupplierInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubSupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubSupplierInfoServiceImpl implements PubSupplierInfoService {
    @Autowired
    PubSupplierInfoMapper supplierInfoMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubSupplierInfo> list = supplierInfoMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String code) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(code)) {
            resultJson.setMsg("供应商编码不能为空!");
            return resultJson;
        }

        PubSupplierInfo supplierInfo = supplierInfoMapper.selectByPrimaryKey(code);
        if (supplierInfo != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(supplierInfo);
        }
        return resultJson;
    }

    @Override
    public ResultJson addSupplier(PubSupplierInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = supplierInfoMapper.getMaxCode() + 1;
        record.setCode(format("%05d",maxCode));
        int i = supplierInfoMapper.insert(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifySupplier(PubSupplierInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if (StringUtils.isEmpty(record.getCode())) {
            resultJson.setMsg("供应商编码不能为空!");
            return resultJson;
        }

        int i = supplierInfoMapper.updateByPrimaryKeyWithBLOBs(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteSupplier(String code) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if (StringUtils.isEmpty(code)) {
            resultJson.setMsg("供应商编码不能为空!");
            return resultJson;
        }
        int i = supplierInfoMapper.deleteByPrimaryKey(code);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }
}
