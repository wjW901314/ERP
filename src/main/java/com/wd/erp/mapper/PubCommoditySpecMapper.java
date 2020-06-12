package com.wd.erp.mapper;

import com.wd.erp.model.PubCommoditySpec;

import java.util.List;

public interface PubCommoditySpecMapper {
    int deleteByPrimaryKey(String specCode);

    int insert(PubCommoditySpec record);

    int insertSelective(PubCommoditySpec record);

    PubCommoditySpec selectByPrimaryKey(String specCode);

    int updateByPrimaryKeySelective(PubCommoditySpec record);

    int updateByPrimaryKey(PubCommoditySpec record);

    List<PubCommoditySpec> getAll(String keyWord);

    PubCommoditySpec getById(String specCode);

    int getMaxCode();



}