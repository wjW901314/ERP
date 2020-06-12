package com.wd.erp.service.impl;

import com.wd.erp.mapper.BusinessCommoditySaleMapper;
import com.wd.erp.model.*;
import com.wd.erp.service.BusinessCommoditySaleService;
import com.wd.erp.until.BasisUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

@Service
public class BusinessCommoditySaleServiceImpl implements BusinessCommoditySaleService {
    @Autowired
    BusinessCommoditySaleMapper commoditySaleMapper;

    @Override
    public ResultJson getAll() {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询失败！");
        resultJson.setSuccess(false);
        List<BusinessCommoditySaleVo> list = commoditySaleMapper.getAll();
        if (list != null) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson addSale(BusinessCommoditySale record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("添加失败！");
        resultJson.setSuccess(false);
        int maxCode = commoditySaleMapper.getMaxCode() + 1;
        record.setId(format("%010d", maxCode));
        record.setStatus(0);
        record.setSaleDate(new Date());
        int i = commoditySaleMapper.insert(record);
        if (i > 0) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("添加成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson auditVoidRecord(String id, String status) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("修改状态失败！");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(status)) {
            resultJson.setMsg("ID或修改状态不能为空!");
            return resultJson;
        }

        int i = commoditySaleMapper.auditVoidRecord(id, status);
        if (i > 0) {
            resultJson.setSuccess(true);
            resultJson.setCode(0);
            resultJson.setMsg("修改状态成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson commodityMonthSalReport(String month) throws ParseException {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setMsg("查询失败！");
        resultJson.setSuccess(false);
        if (StringUtils.isEmpty(month)) {
            resultJson.setMsg("月份不能为空!");
            return resultJson;
        }

        String beginDate = BasisUntil.calMonthFirstAndLastDay(month, 0) + " 00:00:00",
                endDate = BasisUntil.calMonthFirstAndLastDay(month, 1) + " 23:59:59";
        List<CommodityMonthSale> list = commoditySaleMapper.getCommodityMonthSaleList(beginDate, endDate);
        if (list != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;

    }
}
