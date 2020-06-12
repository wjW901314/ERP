package com.wd.erp.service;

import com.wd.erp.model.PubMeteringCompany;
import com.wd.erp.model.ResultJson;

public interface PubMeteringCompanyService {
    ResultJson getAll(String keyWord);
    ResultJson getById(String unitCode);
    ResultJson addMetering(PubMeteringCompany record);
    ResultJson modifyMetering(PubMeteringCompany record);
    ResultJson deleteMetering(String unitCode);
}
