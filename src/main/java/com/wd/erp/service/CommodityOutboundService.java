package com.wd.erp.service;

import com.wd.erp.model.CommodityOutbound;
import com.wd.erp.model.ResultJson;

public interface CommodityOutboundService {
    ResultJson addOutStock(CommodityOutbound commodityOutbound);
    ResultJson deleteOutStock(String id);
    ResultJson modifyOutStock(CommodityOutbound commodityOutbound);
    ResultJson getAll();
    ResultJson getOne(String id);
}
