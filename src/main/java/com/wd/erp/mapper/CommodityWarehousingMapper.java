package com.wd.erp.mapper;

import com.wd.erp.model.CommodityWarehousing;

import java.util.List;

public interface CommodityWarehousingMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommodityWarehousing record);

    int insertSelective(CommodityWarehousing record);

    CommodityWarehousing selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityWarehousing record);

    int updateByPrimaryKey(CommodityWarehousing record);

    List<CommodityWarehousing> getAll();
}