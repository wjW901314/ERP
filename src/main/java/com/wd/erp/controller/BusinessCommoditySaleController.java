package com.wd.erp.controller;

import com.wd.erp.model.BusinessCommoditySale;
import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BusinessCommoditySaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
@RequestMapping("/sale")
public class BusinessCommoditySaleController {
    @Autowired
    BusinessCommoditySaleService commoditySaleService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll() {
        return commoditySaleService.getAll();
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addSale(@RequestBody BusinessCommoditySale record) {
        return commoditySaleService.addSale(record);
    }

    @ResponseBody
    @RequestMapping("/auditVoidRecord")
    public ResultJson auditVoidRecord(String id, String status) {
        return commoditySaleService.auditVoidRecord(id, status);
    }

    @ResponseBody
    @RequestMapping("/commodityMonthSalReport")
    public ResultJson commodityMonthSalReport(String month) throws ParseException {
        return commoditySaleService.commodityMonthSalReport(month);
    }
}
