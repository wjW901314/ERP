package com.wd.erp.service;

import com.wd.erp.model.BusinessCommoditySale;
import com.wd.erp.model.ResultJson;

import java.text.ParseException;

public interface BusinessCommoditySaleService {
    ResultJson getAll();
    ResultJson addSale(BusinessCommoditySale record);
    ResultJson auditVoidRecord(String id,String status);
    ResultJson commodityMonthSalReport(String month) throws ParseException;
}
