package com.wd.erp.controller;

import com.wd.erp.model.BasisUserRole;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BasisUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basis/userRole")
public class BasisUserRoleController {
    @Autowired
    BasisUserRoleService basisUserRoleService;

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addUserRole(@RequestBody BasisUserRole recode){
        return basisUserRoleService.addUserRole(recode);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteUserRole(String id){
        return basisUserRoleService.deleteUserRole(id);
    }


    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return basisUserRoleService.getAll();
    }
}
