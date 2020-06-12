package com.wd.erp.controller;

import com.wd.erp.model.PubMeteringCompany;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubMeteringCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 计量单位
 */
@Controller
@RequestMapping("/MeteringCompany")
public class PubMeteringCompanyController {

    @Autowired
    PubMeteringCompanyService meteringCompanyService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord){
        return meteringCompanyService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String unitCode){
        return meteringCompanyService.getById(unitCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addMetering(@RequestBody PubMeteringCompany record){
        return meteringCompanyService.addMetering(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyMetering(@RequestBody PubMeteringCompany record){
        return meteringCompanyService.modifyMetering(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteMetering(String unitCode){
        return meteringCompanyService.deleteMetering(unitCode);
    }

}
