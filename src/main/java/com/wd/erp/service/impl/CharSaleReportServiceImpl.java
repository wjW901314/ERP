package com.wd.erp.service.impl;

import com.sun.org.slf4j.internal.Logger;
import com.wd.erp.mapper.CharSaleReportMapper;
import com.wd.erp.model.CharSaleReportModel;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.CharSaleReportService;
import com.wd.erp.until.BasisUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharSaleReportServiceImpl implements CharSaleReportService {

    @Autowired
    CharSaleReportMapper charSaleReportMapper;

    @Override
    public ResultJson getCommoditySaleInfo() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询失败!");
        resultJson.setSuccess(false);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        String month = sFormat.format(cal.getTime());
        String beginDate = BasisUntil.calMonthFirstAndLastDay(month, 0);
        String endDate = BasisUntil.calMonthFirstAndLastDay(month, 1);
        List<CharSaleReportModel> list = charSaleReportMapper.gemologistSaleInfo(beginDate, endDate);
        if (list != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson getCurrentMonthCommoditySaleInfo() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询失败!");
        resultJson.setSuccess(false);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        String month = sFormat.format(cal.getTime());
        String beginDate = BasisUntil.calMonthFirstAndLastDay(month, 0);
        String endDate = BasisUntil.calMonthFirstAndLastDay(month, 1);

        Map<String, BigDecimal> baseMap = new HashMap<String, BigDecimal>();
        List<Map<String, Object>> baseList =
                charSaleReportMapper.getCurrentMonthCommoditySaleInfo(beginDate,endDate);
        if (baseMap != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(baseList);
        }
        return resultJson;
    }
}
