package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubDepartmentInfoMapper;
import com.wd.erp.model.PubDepartmentInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubDepartmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubDepartmentInfoServiceImpl implements PubDepartmentInfoService {
    @Autowired
    PubDepartmentInfoMapper departmentInfoMapper;

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询所有部门失败!");
        List<PubDepartmentInfo> list = departmentInfoMapper.getAll("");
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询所有部门成功");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String departCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询部门失败!");
        if (StringUtils.isEmpty(departCode)) {
            resultJson.setMsg("部门编码不能为空!");
            return resultJson;
        }
        PubDepartmentInfo depart = departmentInfoMapper.selectByPrimaryKey(departCode);
        if (depart != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询部门成功");
            resultJson.setData(depart);
        }
        return resultJson;
    }

    @Override
    public ResultJson getKeyWord(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("模糊查询部门失败!");
        if (StringUtils.isEmpty(keyWord)) {
            resultJson.setMsg("关键字不能为空!");
            return resultJson;
        }
        List<PubDepartmentInfo> departList = departmentInfoMapper.getAll(keyWord);
        if (departList.size() > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("模糊查询部门成功");
            resultJson.setData(departList);
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteById(String departCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除部门失败!");
        if (StringUtils.isEmpty(departCode)) {
            resultJson.setMsg("部门编码不能为空!");
            return resultJson;
        }
        int i = departmentInfoMapper.deleteByPrimaryKey(departCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除部门成功");
        }
        return resultJson;
    }

    @Override
    public ResultJson addDepartment(PubDepartmentInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加部门失败!");
        int maxCode = departmentInfoMapper.getMaxCode() + 1;
        record.setDepartCode(format("%05d", maxCode));
        int i = departmentInfoMapper.insert(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加部门成功");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyDepartment(PubDepartmentInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改部门失败!");
        int i = departmentInfoMapper.updateByPrimaryKeySelective(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改部门成功");
        }
        return resultJson;
    }
}
