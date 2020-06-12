package com.wd.erp.service;

import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.ResultJson;

public interface BusinessCommodityStockService {
    ResultJson getAll();

    ResultJson getById(String id);

    ResultJson fuzzyStockRecord(String keyWord);

    ResultJson addStock(BusinessCommodityStock record);

    ResultJson modifyStock(BusinessCommodityStock record);

    ResultJson deleteStock(String id);
}
