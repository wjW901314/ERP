package com.wd.erp.controller;

import com.wd.erp.model.CommodityOutbound;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/business/outStock")
public class CommodityOutboundController {
    @Autowired
    CommodityOutboundService commodityOutboundService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll() {
        return commodityOutboundService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String id) {
        return commodityOutboundService.getOne(id);
    }


    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addOutbound(@RequestBody CommodityOutbound commodityOutbound) {
        return commodityOutboundService.addOutStock(commodityOutbound);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyOutbound(@RequestBody CommodityOutbound commodityOutbound) {
        return commodityOutboundService.modifyOutStock(commodityOutbound);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteOutbound(String id) {
        return commodityOutboundService.deleteOutStock(id);
    }
}
