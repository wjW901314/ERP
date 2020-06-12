package com.wd.erp.service;

import com.wd.erp.model.CommodityWarehousing;
import com.wd.erp.model.ResultJson;

public interface CommodityWarehousingService {
    ResultJson addStock(CommodityWarehousing record);
    ResultJson deleteStock(String id);
    ResultJson getById(String id);
    ResultJson getAll();
    ResultJson modifyStockById(CommodityWarehousing record);
}
