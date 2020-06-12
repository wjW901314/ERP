package com.wd.erp.service;

import com.wd.erp.model.BasisUserRole;
import com.wd.erp.model.ResultJson;

public interface BasisUserRoleService {
    ResultJson addUserRole(BasisUserRole recode);
    ResultJson getAll();
    ResultJson deleteUserRole(String id);
}
