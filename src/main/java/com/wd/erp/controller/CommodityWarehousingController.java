package com.wd.erp.controller;

import com.wd.erp.model.CommodityWarehousing;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CommodityWarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/business/stock")
public class CommodityWarehousingController {

    @Autowired
    CommodityWarehousingService commodityWarehousingService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(){
        return commodityWarehousingService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String id){
        return commodityWarehousingService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addWarehousing(@RequestBody CommodityWarehousing commodityWarehousing){
        return commodityWarehousingService.addStock(commodityWarehousing);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyWarehousing(@RequestBody CommodityWarehousing commodityWarehousing){
        return commodityWarehousingService.modifyStockById(commodityWarehousing);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteWarehousing(String id){
        return commodityWarehousingService.deleteStock(id);
    }
}
