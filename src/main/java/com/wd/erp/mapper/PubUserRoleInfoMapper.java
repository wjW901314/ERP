package com.wd.erp.mapper;

import com.wd.erp.model.PubUserRoleInfo;

import java.util.List;

public interface PubUserRoleInfoMapper {
    int deleteByPrimaryKey(String roleCoed);

    int insert(PubUserRoleInfo record);

    int insertSelective(PubUserRoleInfo record);

    PubUserRoleInfo selectByPrimaryKey(String roleCoed);

    int updateByPrimaryKeySelective(PubUserRoleInfo record);

    int updateByPrimaryKey(PubUserRoleInfo record);

    List<PubUserRoleInfo> getAll(String keyWord);

    PubUserRoleInfo getById(String roleCode);

    int getMaxCode();
}