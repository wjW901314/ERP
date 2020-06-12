package com.wd.erp.service;

import com.wd.erp.model.CommodityManagement;
import com.wd.erp.model.ResultJson;

public interface CommodityManagementService {
    ResultJson addCommodity(CommodityManagement commodityManagement);
    ResultJson deleteByPrimaryKey(String id);
    ResultJson modifyCommodity(CommodityManagement commodityManagement);
    ResultJson getAll();
    ResultJson getById(String id);
}
