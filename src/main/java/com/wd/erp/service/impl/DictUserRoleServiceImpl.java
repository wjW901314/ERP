package com.wd.erp.service.impl;

import com.wd.erp.mapper.DictUserRoleMapper;
import com.wd.erp.model.DictUserRole;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.DictUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictUserRoleServiceImpl implements DictUserRoleService {

    @Autowired
    DictUserRoleMapper dictUserRoleMapper;

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<DictUserRole> list = dictUserRoleMapper.getAll();
        if(list.size() > 0){
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }
}
