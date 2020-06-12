package com.wd.erp.controller;

import com.wd.erp.model.BusinessCommodityPurchase;
import com.wd.erp.model.BusinessCommodityPurchaseEx;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.BusinessCommodityPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品进货控制器
 */
@Controller
@RequestMapping("/commodityPurchase")
public class BusinessCommodityPurchaseController {
    @Autowired
    BusinessCommodityPurchaseService commodityPurchaseService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return commodityPurchaseService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addCommodityPurchase(@RequestBody BusinessCommodityPurchaseEx record) {
        return commodityPurchaseService.addCommodityPurchase(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyCommodityPurchase(@RequestBody BusinessCommodityPurchaseEx record) {
        return commodityPurchaseService.modifyCommodityPurchase(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteCommodityPurchase(String purchaseCode) {
        return commodityPurchaseService.deleteCommodityPurchase(purchaseCode);
    }

    @ResponseBody
    @RequestMapping("/auditVoidRecord")
    public ResultJson auditVoidRecord(String id,String status){
        return commodityPurchaseService.auditVoidRecord(id,status);
    }
}
