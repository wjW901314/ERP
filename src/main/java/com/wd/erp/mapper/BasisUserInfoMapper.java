package com.wd.erp.mapper;

import com.wd.erp.model.BasisUserInfo;

import java.util.List;

public interface BasisUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasisUserInfo record);

    int insertSelective(BasisUserInfo record);

    BasisUserInfo selectByPrimaryKey(Integer id);

    BasisUserInfo selectOne(String userCode);

    List<BasisUserInfo> selectList();

    int updateByPrimaryKeySelective(BasisUserInfo record);

    int updateByPrimaryKey(BasisUserInfo record);

    int deleteUser(String userCode);
}