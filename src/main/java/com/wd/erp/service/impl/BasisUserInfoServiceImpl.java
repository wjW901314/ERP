package com.wd.erp.service.impl;

import com.wd.erp.mapper.BasisUserInfoMapper;
import com.wd.erp.model.BasisUserInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BasisUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/*
基础-用户信息Service
 */
@Service
public class BasisUserInfoServiceImpl implements BasisUserInfoService {

    @Autowired
    BasisUserInfoMapper basisUserInfoMapper;


    @Override
    public ResultJson addUser(BasisUserInfo basisUserInfo) {
        ResultJson resultJson = new ResultJson();

        if(StringUtils.isEmpty(basisUserInfo.getId())){
            resultJson.setMsg("用户编码不能为空!");
            resultJson.setSuccess(false);
            resultJson.setCode(1);
            return resultJson;
        }
        String id = UUID.randomUUID().toString().substring(24);
        int i = basisUserInfoMapper.insert(basisUserInfo);
        if(i == 1){
            resultJson.setCode(0);
            resultJson.setMsg("添加用户成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyUser(BasisUserInfo basisUserInfo) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg("添加用户失败!");
        if(basisUserInfoMapper.updateByPrimaryKey(basisUserInfo) > 1){
            resultJson.setCode(0);
            resultJson.setMsg("添加用户成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteUser(String userCode) {
        ResultJson resultJson = new ResultJson();
        if(StringUtils.isEmpty(userCode)){
            resultJson.setMsg("用户编码不能为空!");
            resultJson.setSuccess(false);
            resultJson.setCode(1);
            return resultJson;
        }
        int i = basisUserInfoMapper.deleteUser(userCode);
        if(i == 1){
            resultJson.setCode(0);
            resultJson.setMsg("删除用户成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        List<BasisUserInfo> list = basisUserInfoMapper.selectList();
        if(list.size() <= 0){
            resultJson.setCode(1);
            resultJson.setSuccess(false);
            resultJson.setMsg("查询所有用户失败!");
            resultJson.setData(null);
            return resultJson;
        }
        resultJson.setCode(0);
        resultJson.setSuccess(true);
        resultJson.setMsg("查询成功!");
        resultJson.setData(list);
        return resultJson;
    }

    @Override
    public ResultJson getById(String userCode) {
        ResultJson resultJson = new ResultJson();
        BasisUserInfo basisUserInfo = basisUserInfoMapper.selectOne(userCode);
        if(basisUserInfo == null){
            resultJson.setCode(1);
            resultJson.setSuccess(false);
            resultJson.setMsg("查询用户失败!");
            resultJson.setData(null);
            return resultJson;
        }
        resultJson.setCode(0);
        resultJson.setSuccess(true);
        resultJson.setMsg("查询成功!");
        resultJson.setData(basisUserInfo);
        return resultJson;
    }

    @Override
    public ResultJson getUserInfo(String userCode, String userPwd) {
        ResultJson resultJson = new ResultJson();
        BasisUserInfo basisUserInfo = basisUserInfoMapper.selectOne(userCode);
        if(StringUtils.isEmpty(userCode)){
            resultJson.setCode(1);
            resultJson.setSuccess(false);
            resultJson.setMsg("用户编码不能为空!");
            resultJson.setData(null);
            return resultJson;
        }
        if(basisUserInfo != null && !StringUtils.isEmpty(basisUserInfo.getId())){
            if(basisUserInfo.getUserPwd().equals(userPwd)){
                resultJson.setCode(0);
                resultJson.setSuccess(true);
                resultJson.setMsg("登录成功!");
            }else{
                resultJson.setCode(1);
                resultJson.setSuccess(false);
                resultJson.setMsg("密码错误!");
            }
        }else{
            resultJson.setCode(1);
            resultJson.setSuccess(false);
            resultJson.setMsg("用户不存在!");
        }
        resultJson.setData(null);
        return resultJson;
    }
}
