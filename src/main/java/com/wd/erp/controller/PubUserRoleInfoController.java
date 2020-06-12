package com.wd.erp.controller;

import com.wd.erp.model.PubUserRoleInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubUserRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userRole")
public class PubUserRoleInfoController {

    @Autowired
    PubUserRoleInfoService userRoleInfoService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return userRoleInfoService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String roleCode) {
        return userRoleInfoService.getById(roleCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addUserRole(@RequestBody PubUserRoleInfo record) {
        return userRoleInfoService.addUserRole(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyUserRole(@RequestBody PubUserRoleInfo record) {
        return userRoleInfoService.modifyUserRole(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteUserRole(String roleCode) {
        return userRoleInfoService.deleteUserRole(roleCode);
    }
}
