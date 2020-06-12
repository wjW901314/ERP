package com.wd.erp.service;

import com.wd.erp.model.PubUserRoleInfo;
import com.wd.erp.model.ResultJson;

public interface PubUserRoleInfoService {
    ResultJson getAll(String keyWord);

    ResultJson getById(String roleCode);

    ResultJson addUserRole(PubUserRoleInfo record);

    ResultJson modifyUserRole(PubUserRoleInfo record);

    ResultJson deleteUserRole(String roleCode);
}
