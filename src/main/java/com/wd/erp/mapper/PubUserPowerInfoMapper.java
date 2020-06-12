package com.wd.erp.mapper;

import com.wd.erp.model.PubUserPowerInfo;

public interface PubUserPowerInfoMapper {
    int deleteByPrimaryKey(String powerCode);

    int insert(PubUserPowerInfo record);

    int insertSelective(PubUserPowerInfo record);

    PubUserPowerInfo selectByPrimaryKey(String powerCode);

    int updateByPrimaryKeySelective(PubUserPowerInfo record);

    int updateByPrimaryKey(PubUserPowerInfo record);
}