package com.wd.erp.controller;

import com.wd.erp.model.BasisUserInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BasisUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/basis/user")
public class BasisUserInfoController {

    @Autowired
    BasisUserInfoService basisUserInfoService;

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addUserInfo(@RequestBody BasisUserInfo basisUserInfo){
        return basisUserInfoService.addUser(basisUserInfo);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyUserInfo(@RequestBody BasisUserInfo basisUserInfo){
        return basisUserInfoService.modifyUser(basisUserInfo);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteUserInfo(String userCode){
        return basisUserInfoService.deleteUser(userCode);
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return basisUserInfoService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getOne")
    public ResultJson getOne(String userCode){
        return basisUserInfoService.getById(userCode);
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResultJson checkUserInfo(String userCode,String userPwd){
        return basisUserInfoService.getUserInfo(userCode,userPwd);
    }
}
