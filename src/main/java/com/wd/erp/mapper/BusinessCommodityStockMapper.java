package com.wd.erp.mapper;

import com.wd.erp.model.BusinessCommodityStock;
import com.wd.erp.model.BusinessCommodityStockVo;

import java.util.List;

public interface BusinessCommodityStockMapper {
    int deleteByPrimaryKey(String id);

    int insert(BusinessCommodityStock record);

    int insertSelective(BusinessCommodityStock record);

    BusinessCommodityStock selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BusinessCommodityStock record);

    int updateByPrimaryKey(BusinessCommodityStock record);

    List<BusinessCommodityStockVo> getAll();

    List<BusinessCommodityStockVo> fuzzyStockRecord(String keyWord);

    int getMaxCode();

    int auditVoidRecord(String id, String status);
}