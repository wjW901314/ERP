package com.wd.erp.mapper;

import com.wd.erp.model.PubCommodityInfo;

import java.util.List;

public interface PubCommodityInfoMapper {
    int deleteByPrimaryKey(String commodityCode);

    int insert(PubCommodityInfo record);

    int insertSelective(PubCommodityInfo record);

    PubCommodityInfo selectByPrimaryKey(String commodityCode);

    int updateByPrimaryKeySelective(PubCommodityInfo record);

    int updateByPrimaryKeyWithBLOBs(PubCommodityInfo record);

    int updateByPrimaryKey(PubCommodityInfo record);

    List<PubCommodityInfo> getAll(String keyWord);

    PubCommodityInfo getById(String commodityCode);
    int getMaxCode();

}