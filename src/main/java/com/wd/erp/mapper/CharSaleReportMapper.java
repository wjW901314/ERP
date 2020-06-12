package com.wd.erp.mapper;

import com.wd.erp.model.CharSaleReportModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CharSaleReportMapper {
    List<CharSaleReportModel> gemologistSaleInfo(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<Map<String, Object>> getCurrentMonthCommoditySaleInfo(@Param("beginDate") String beginDate,@Param("endDate") String endDate);
}
