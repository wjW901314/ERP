package com.wd.erp.controller;

import com.wd.erp.model.PubDepartmentInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubDepartmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/depart")
public class PubDepartmentInfoController {
    @Autowired
    PubDepartmentInfoService departmentInfoService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll() {
        return departmentInfoService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String departCode) {
        return departmentInfoService.getById(departCode);
    }

    @ResponseBody
    @RequestMapping("/getKeyWord")
    public ResultJson getKeyWord(String keyWord) {
        return departmentInfoService.getKeyWord(keyWord);
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultJson deleteById(String departCode) {
        return departmentInfoService.deleteById(departCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addDepartment(@RequestBody PubDepartmentInfo record) {
        return departmentInfoService.addDepartment(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyDepartment(@RequestBody PubDepartmentInfo record) {
        return departmentInfoService.modifyDepartment(record);
    }
}
