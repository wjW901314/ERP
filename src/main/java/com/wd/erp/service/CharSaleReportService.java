package com.wd.erp.service;

import com.wd.erp.model.ResultJson;

public interface CharSaleReportService {
    ResultJson getCommoditySaleInfo();
    ResultJson getCurrentMonthCommoditySaleInfo();
}
