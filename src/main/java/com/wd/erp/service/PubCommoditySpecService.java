package com.wd.erp.service;

import com.wd.erp.model.PubCommoditySpec;
import com.wd.erp.model.ResultJson;

public interface PubCommoditySpecService {
    ResultJson getAll(String keyWord);
    ResultJson getById(String specCode);
    ResultJson addSpec(PubCommoditySpec record);
    ResultJson modifySpec(PubCommoditySpec record);
    ResultJson deleteSpec(String specCode);
}
