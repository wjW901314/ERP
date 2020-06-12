package com.wd.erp.controller;

import com.wd.erp.model.PubCommodityType;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodityType")
public class PubCommodityTypeController {
    @Autowired
    PubCommodityTypeService commodityTypeService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return commodityTypeService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String typeCode) {
        return commodityTypeService.getById(typeCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addCommodityType(@RequestBody PubCommodityType record) {
        return commodityTypeService.addCommodityType(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyCommodityType(@RequestBody PubCommodityType record) {
        return commodityTypeService.modifyCommodityType(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteCommodityType(String typeCode) {
        return commodityTypeService.deleteCommodityType(typeCode);
    }
}
