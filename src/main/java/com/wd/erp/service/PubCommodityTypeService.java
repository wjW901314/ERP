package com.wd.erp.service;

import com.wd.erp.model.PubCommodityType;
import com.wd.erp.model.ResultJson;

public interface PubCommodityTypeService {
    ResultJson getAll(String keyWord);
    ResultJson getById(String typeCode);
    ResultJson addCommodityType(PubCommodityType record);
    ResultJson modifyCommodityType(PubCommodityType record);
    ResultJson deleteCommodityType(String typeCode);
}
