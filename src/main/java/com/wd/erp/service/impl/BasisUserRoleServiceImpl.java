package com.wd.erp.service.impl;

import com.wd.erp.mapper.BasisUserRoleMapper;
import com.wd.erp.model.BasisUserRole;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BasisUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BasisUserRoleServiceImpl implements BasisUserRoleService {

    @Autowired
    BasisUserRoleMapper basisUserRoleMapper;

    @Override
    public ResultJson addUserRole(BasisUserRole recode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("添加用户角色失败!");
        if(StringUtils.isEmpty(recode.getLoginName())){
            resultJson.setMsg("用户名不能为空!");
            return resultJson;
        }
        int i = basisUserRoleMapper.insert(recode);
        if(i == 1){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("添加用户角色成功!");
            resultJson.setData(i);
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询失败!");
        resultJson.setSuccess(false);
        List<BasisUserRole> list = basisUserRoleMapper.getAll();
        if(list.size() >= 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteUserRole(String id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除用户角色失败!");
        if(StringUtils.isEmpty(id)){
            resultJson.setMsg("id不能为空!");
            return resultJson;
        }
        int i = basisUserRoleMapper.deleteByPrimaryKey(id);
        if(i == 1){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除用户角色成功!");
            resultJson.setData(i);
        }
        return resultJson;
    }
}
