package com.wd.erp.mapper;

import com.wd.erp.model.CommodityOutbound;

import java.util.List;

public interface CommodityOutboundMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommodityOutbound record);

    int insertSelective(CommodityOutbound record);

    CommodityOutbound selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityOutbound record);

    int updateByPrimaryKey(CommodityOutbound record);

    List<CommodityOutbound> getAll();
}