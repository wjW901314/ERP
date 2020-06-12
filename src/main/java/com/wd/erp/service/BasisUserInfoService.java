package com.wd.erp.service;

import com.wd.erp.model.BasisUserInfo;
import com.wd.erp.model.ResultJson;

public interface BasisUserInfoService {
    ResultJson addUser(BasisUserInfo basisUserInfo);
    ResultJson modifyUser(BasisUserInfo basisUserInfo);
    ResultJson deleteUser(String userCode);
    ResultJson getAll();
    ResultJson getById(String userCode);
    ResultJson getUserInfo(String userCode, String userPwd);
}
