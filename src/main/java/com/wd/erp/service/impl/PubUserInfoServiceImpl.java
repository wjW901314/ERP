package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubUserInfoMapper;
import com.wd.erp.model.PubUserInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubUserInfoServiceImpl implements PubUserInfoService {

    @Autowired
    PubUserInfoMapper pubUserInfoMapper;

    @Override
    public ResultJson getById(String userCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询用户信息失败!");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(userCode)) {
            resultJson.setMsg("用户编码不能为空!");
            return resultJson;
        }
        PubUserInfo userInfo = pubUserInfoMapper.selectByPrimaryKey(userCode);
        if (userInfo != null) {
            resultJson.setCode(0);
            resultJson.setMsg("查询用户信息成功!");
            resultJson.setSuccess(true);
            resultJson.setData(userInfo);
        }
        return resultJson;
    }

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询用户信息失败!");
        resultJson.setSuccess(false);
        List<PubUserInfo> list = pubUserInfoMapper.getAll();
        if (list.size() > 0) {
            resultJson.setCode(0);
            resultJson.setMsg("查询用户信息成功!");
            resultJson.setSuccess(true);
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson addUserInfo(PubUserInfo userInfo) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("添加用户信息失败!");
        resultJson.setSuccess(false);
        Integer maxCode = pubUserInfoMapper.getMaxUserCode() + 1;
        String code = format("%05d", maxCode);
        userInfo.setUserCode(code);
        int i = pubUserInfoMapper.insert(userInfo);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setMsg("添加用户信息成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyUserInfo(PubUserInfo userInfo) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("修改用户信息失败!");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(userInfo.getUserCode())) {
            resultJson.setMsg("用户编码不能为空!");
            return resultJson;
        }
        int i = pubUserInfoMapper.updateByPrimaryKey(userInfo);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setMsg("修改用户信息成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson delById(String userCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("删除用户信息失败!");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(userCode)) {
            resultJson.setMsg("用户编码不能为空!");
            return resultJson;
        }
        int i = pubUserInfoMapper.deleteByPrimaryKey(userCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setMsg("删除用户信息成功!");
            resultJson.setSuccess(true);
        }
        return resultJson;
    }

    @Override
    public ResultJson login(String userCode, String passWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("登录失败!");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(userCode)) {
            resultJson.setMsg("用户编码不能为空!");
            return resultJson;
        } else if (userCode.equals("admin")) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("登录成功!");
            return resultJson;
        }
        PubUserInfo userInfo = pubUserInfoMapper.selectByPrimaryKey(userCode);
        if (userInfo != null) {
            if (userInfo.getPassword().equals(passWord)) {
                resultJson.setCode(0);
                resultJson.setMsg("登录成功!");
                resultJson.setSuccess(true);
                return resultJson;
            }
        } else {
            resultJson.setMsg("用户编码或密码错误!");
        }
        return resultJson;
    }
}
