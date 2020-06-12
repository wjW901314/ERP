package com.wd.erp.controller;

import com.wd.erp.model.ResultJson;
import com.wd.erp.service.DictUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dict/userRole")
public class DictUserRoleController {
    @Autowired
    DictUserRoleService dictUserRoleService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return dictUserRoleService.getAll();
    }
}
