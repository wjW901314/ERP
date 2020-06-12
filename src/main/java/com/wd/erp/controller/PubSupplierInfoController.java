package com.wd.erp.controller;

import com.wd.erp.model.PubSupplierInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubSupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/supplier")
public class PubSupplierInfoController {
    @Autowired
    PubSupplierInfoService supplierInfoService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return supplierInfoService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String code) {
        return supplierInfoService.getById(code);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addSupplier(@RequestBody PubSupplierInfo record) {
        return supplierInfoService.addSupplier(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifySupplier(@RequestBody PubSupplierInfo record) {
        return supplierInfoService.modifySupplier(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteSupplier(String code) {
        return supplierInfoService.deleteSupplier(code);
    }
}
