package com.wd.erp.service;

import com.wd.erp.model.PubCommodityInfo;
import com.wd.erp.model.ResultJson;

public interface PubCommodityInfoService {
    ResultJson getAll(String keyWord);
    ResultJson getById(String commodityCode);
    ResultJson addCommodity(PubCommodityInfo record);
    ResultJson modifyCommodity(PubCommodityInfo record);
    ResultJson deleteCommodity(String commodityCode);
}
