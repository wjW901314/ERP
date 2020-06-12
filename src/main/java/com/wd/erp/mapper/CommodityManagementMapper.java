package com.wd.erp.mapper;

import com.wd.erp.model.CommodityManagement;

import java.util.List;

public interface CommodityManagementMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommodityManagement record);

    int insertSelective(CommodityManagement record);

    CommodityManagement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityManagement record);

    int updateByPrimaryKey(CommodityManagement record);

    int getMaxId();

    List<CommodityManagement> getAll();

    CommodityManagement getOne(String id);
}