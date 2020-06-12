package com.wd.erp.mapper;

import com.wd.erp.model.PubUserInfo;

import java.util.List;

public interface PubUserInfoMapper {
    int deleteByPrimaryKey(String userCode);

    int insert(PubUserInfo record);

    int insertSelective(PubUserInfo record);

    PubUserInfo selectByPrimaryKey(String userCode);

    int updateByPrimaryKeySelective(PubUserInfo record);

    int updateByPrimaryKey(PubUserInfo record);

    List<PubUserInfo> getAll();

    int getMaxUserCode();
}