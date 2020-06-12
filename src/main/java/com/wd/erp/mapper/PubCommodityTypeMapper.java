package com.wd.erp.mapper;

import com.wd.erp.model.PubCommodityType;

import java.util.List;

public interface PubCommodityTypeMapper {
    int deleteByPrimaryKey(String typeCode);

    int insert(PubCommodityType record);

    int insertSelective(PubCommodityType record);

    PubCommodityType selectByPrimaryKey(String typeCode);

    int updateByPrimaryKeySelective(PubCommodityType record);

    int updateByPrimaryKey(PubCommodityType record);

    List<PubCommodityType> getAll(String keyWord);

    int getMaxCode();
}