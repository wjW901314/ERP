package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubUserRoleInfoMapper;
import com.wd.erp.model.PubUserRoleInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubUserRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubUserRoleInfoServiceImpl implements PubUserRoleInfoService {
    @Autowired
    PubUserRoleInfoMapper userRoleInfoMapper;

    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubUserRoleInfo> list = userRoleInfoMapper.getAll(keyWord);
        if (list.size() > 0) {
            resultJson.setMsg("查询成功!");
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getById(String roleCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        if (StringUtils.isEmpty(roleCode)) {
            resultJson.setMsg("角色编码不能为空!");
            return resultJson;
        }
        PubUserRoleInfo userRoleInfo = userRoleInfoMapper.getById(roleCode);
        if (userRoleInfo != null) {
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setSuccess(true);
            resultJson.setData(userRoleInfo);
        }
        return resultJson;
    }

    @Override
    public ResultJson addUserRole(PubUserRoleInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加失败!");
        int maxCode = userRoleInfoMapper.getMaxCode();
        record.setRoleCoed(format("%05d",maxCode));
        int i = userRoleInfoMapper.insert(record);
        if(i > 0){
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyUserRole(PubUserRoleInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if(StringUtils.isEmpty(record.getRoleCoed())){
            resultJson.setMsg("角色编码不能为空!");
            return resultJson;
        }
        int i = userRoleInfoMapper.updateByPrimaryKey(record);
        if(i > 0){
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteUserRole(String roleCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if(StringUtils.isEmpty(roleCode)){
            resultJson.setMsg("角色编码不能为空!");
            return resultJson;
        }
        int i = userRoleInfoMapper.deleteByPrimaryKey(roleCode);
        if(i > 0){
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }
}
