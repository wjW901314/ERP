package com.wd.erp.mapper;

import com.wd.erp.model.BusinessCommodityPurchase;

import java.util.List;

public interface BusinessCommodityPurchaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(BusinessCommodityPurchase record);

    int insertSelective(BusinessCommodityPurchase record);

    BusinessCommodityPurchase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BusinessCommodityPurchase record);

    int updateByPrimaryKey(BusinessCommodityPurchase record);

    List<BusinessCommodityPurchase> getAll(String keyWord);

    int getMaxCode();

    int auditVoidRecord(String id,String status);
}