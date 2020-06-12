package com.wd.erp.controller;

import com.wd.erp.model.CommodityManagement;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
商品管理控制器
 */
@Controller
@RequestMapping("/business/commodity")
public class CommodityManagementController {

    @Autowired
    CommodityManagementService commodityManagementService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return commodityManagementService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String id){
        return commodityManagementService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addCommodity(@RequestBody CommodityManagement model){
        return commodityManagementService.addCommodity(model);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyCommodity(@RequestBody CommodityManagement model){
        return commodityManagementService.modifyCommodity(model);
    }
}
