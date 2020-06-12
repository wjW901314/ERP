package com.wd.erp.controller;

import com.wd.erp.model.PubCommoditySpec;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubCommoditySpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品规格
 */
@Controller
@RequestMapping("/spec")
public class PubCommoditySpecController {
    @Autowired
    PubCommoditySpecService commoditySpecService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return commoditySpecService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public ResultJson getById(String specCode) {
        return commoditySpecService.getById(specCode);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addSpec(@RequestBody PubCommoditySpec record) {
        return commoditySpecService.addSpec(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifySpec(@RequestBody PubCommoditySpec record) {
        return commoditySpecService.modifySpec(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteSpec(String specCode) {
        return commoditySpecService.deleteSpec(specCode);
    }

}
