package com.wd.erp.service;

import com.wd.erp.model.PubSupplierInfo;
import com.wd.erp.model.ResultJson;

public interface PubSupplierInfoService {
    ResultJson getAll(String keyWord);
    ResultJson getById(String code);
    ResultJson addSupplier(PubSupplierInfo record);
    ResultJson modifySupplier(PubSupplierInfo record);
    ResultJson deleteSupplier(String code);
}
