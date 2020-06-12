package com.wd.erp.controller;

import com.wd.erp.model.PubUserInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class PubUserInfoController {

    @Autowired
    PubUserInfoService userInfoService;

    @ResponseBody
    @RequestMapping("/login")
    public ResultJson login(String userCode,String passWord){
        return userInfoService.login(userCode,passWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String userCode){
        return userInfoService.getById(userCode);
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return userInfoService.getAll();
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addUserInfo(@RequestBody PubUserInfo userInfo){
        return userInfoService.addUserInfo(userInfo);
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultJson deleteById(String userCode){
        return userInfoService.delById(userCode);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyUserInfo(@RequestBody PubUserInfo userInfo){
        return userInfoService.modifyUserInfo(userInfo);
    }
}
