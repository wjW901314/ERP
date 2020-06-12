package com.wd.erp.controller;

import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BusinessCommodityStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品入库
 */
@Controller
@RequestMapping("/stock")
public class BusinessCommodityStockController {
    @Autowired
    BusinessCommodityStockService businessCommodityStockService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll() {
        return businessCommodityStockService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String id) {
        return businessCommodityStockService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/fuzzyStockRecord")
    public ResultJson fuzzyStockRecord(String keyWord) {
        return businessCommodityStockService.fuzzyStockRecord(keyWord);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addStock(@RequestBody BusinessCommodityStock record) {
        return businessCommodityStockService.addStock(record);
    }
}
