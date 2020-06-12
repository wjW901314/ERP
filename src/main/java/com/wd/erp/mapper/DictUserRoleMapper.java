package com.wd.erp.mapper;

import com.wd.erp.model.DictUserRole;

import java.util.List;

public interface DictUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(DictUserRole record);

    int insertSelective(DictUserRole record);

    DictUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictUserRole record);

    int updateByPrimaryKey(DictUserRole record);

    List<DictUserRole> getAll();
}