package com.wd.erp.controller;

import com.wd.erp.model.PubCommodityInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodityInfo")
public class PubCommodityInfoController {
    @Autowired
    PubCommodityInfoService commodityInfoService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return commodityInfoService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String commodityCode) {
        return commodityInfoService.getById(commodityCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addCommodity(@RequestBody PubCommodityInfo record) {
        return commodityInfoService.addCommodity(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyCommodity(@RequestBody PubCommodityInfo record) {
        return commodityInfoService.modifyCommodity(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteCommodity(String commodityCode) {
        return commodityInfoService.deleteCommodity(commodityCode);
    }
}
