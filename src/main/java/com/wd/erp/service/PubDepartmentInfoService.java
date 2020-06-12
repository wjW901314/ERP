package com.wd.erp.service;

import com.wd.erp.model.PubDepartmentInfo;
import com.wd.erp.model.ResultJson;

public interface PubDepartmentInfoService {
    ResultJson getAll();
    ResultJson getById(String departCode);
    ResultJson getKeyWord(String keyWord);
    ResultJson deleteById(String departCode);
    ResultJson addDepartment(PubDepartmentInfo record);
    ResultJson modifyDepartment(PubDepartmentInfo record);
}
