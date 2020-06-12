package com.wd.erp.mapper;

import com.wd.erp.model.BasisUserRole;

import java.util.List;

public interface BasisUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(BasisUserRole record);

    int insertSelective(BasisUserRole record);

    BasisUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasisUserRole record);

    int updateByPrimaryKey(BasisUserRole record);

    List<BasisUserRole> getAll();
}