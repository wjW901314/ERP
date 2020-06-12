package com.wd.erp.service;

import com.wd.erp.model.PubUserInfo;
import com.wd.erp.model.ResultJson;

public interface PubUserInfoService {
    ResultJson getById(String userCode);
    ResultJson getAll();
    ResultJson addUserInfo(PubUserInfo userInfo);
    ResultJson modifyUserInfo(PubUserInfo userInfo);
    ResultJson delById(String userCode);
    ResultJson login(String userCode,String passWord);
}
