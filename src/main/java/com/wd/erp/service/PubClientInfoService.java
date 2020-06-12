package com.wd.erp.service;

import com.wd.erp.model.PubClientInfo;
import com.wd.erp.model.ResultJson;

public interface PubClientInfoService {
    ResultJson getAll(String keyWord);
    ResultJson addClientInfo(PubClientInfo record);
    ResultJson modifyClientInfo(PubClientInfo record);
    ResultJson deleteClientInfo(String clientCode);


}
