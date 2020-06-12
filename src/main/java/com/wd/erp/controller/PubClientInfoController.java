package com.wd.erp.controller;

import com.wd.erp.model.PubClientInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/client")
public class PubClientInfoController {
    @Autowired
    PubClientInfoService clientInfoService;

    @ResponseBody
    @RequestMapping("/getAll")
    public ResultJson getAll(String keyWord) {
        return clientInfoService.getAll(keyWord);
    }

    @ResponseBody
    @RequestMapping("/add")
    public ResultJson addClientInfo(@RequestBody PubClientInfo record) {
        return clientInfoService.addClientInfo(record);
    }

    @ResponseBody
    @RequestMapping("/modify")
    public ResultJson modifyClientInfo(@RequestBody PubClientInfo record) {
        return clientInfoService.modifyClientInfo(record);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultJson deleteClientInfo(String clientCode) {
        return clientInfoService.deleteClientInfo(clientCode);
    }

}
