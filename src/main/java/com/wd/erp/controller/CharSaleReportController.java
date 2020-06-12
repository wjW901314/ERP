package com.wd.erp.controller;

import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CharSaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/saleReport")
public class CharSaleReportController {
    @Autowired
    CharSaleReportService charSaleReportService;

    @ResponseBody
    @RequestMapping("/gemologistSaleInfo")
    public ResultJson gemologistSaleInfo() {
        return charSaleReportService.getCommoditySaleInfo();
    }

    @ResponseBody
    @RequestMapping("/getCurrentMonthCommoditySaleInfo")
    public ResultJson getCurrentMonthCommoditySaleInfo() {
        return charSaleReportService.getCurrentMonthCommoditySaleInfo();
    }
}
