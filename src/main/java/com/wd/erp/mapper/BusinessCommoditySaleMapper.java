package com.wd.erp.mapper;

import com.wd.erp.model.BusinessCommoditySale;
import com.wd.erp.model.BusinessCommoditySaleVo;
import com.wd.erp.model.BusinessCommodityStockVo;
import com.wd.erp.model.CommodityMonthSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessCommoditySaleMapper {
    int deleteByPrimaryKey(String id);

    int insert(BusinessCommoditySale record);

    int insertSelective(BusinessCommoditySale record);

    BusinessCommoditySale selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BusinessCommoditySale record);

    int updateByPrimaryKeyWithBLOBs(BusinessCommoditySale record);

    int updateByPrimaryKey(BusinessCommoditySale record);

    int getMaxCode();

    List<BusinessCommoditySaleVo> getAll();

    int auditVoidRecord(String id, String status);

    List<CommodityMonthSale> getCommodityMonthSaleList(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}