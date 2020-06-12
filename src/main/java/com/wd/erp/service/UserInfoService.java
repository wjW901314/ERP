package com.wd.erp.service;

import com.github.pagehelper.PageInfo;
import com.wd.erp.model.UserInfo;

public interface UserInfoService {
    int addUser(UserInfo user);
    PageInfo<UserInfo> findAllUser(int pageNum, int pageSize);
    boolean getUserInfo(int userCode,String userPwd);
}
