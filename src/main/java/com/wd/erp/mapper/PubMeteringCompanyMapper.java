package com.wd.erp.mapper;

import com.wd.erp.model.PubMeteringCompany;

import java.util.List;

public interface PubMeteringCompanyMapper {
    int deleteByPrimaryKey(String unitCode);

    int insert(PubMeteringCompany record);

    int insertSelective(PubMeteringCompany record);

    PubMeteringCompany selectByPrimaryKey(String unitCode);

    int updateByPrimaryKeySelective(PubMeteringCompany record);

    int updateByPrimaryKey(PubMeteringCompany record);

    List<PubMeteringCompany> getAll(String keyWord);

    PubMeteringCompany getById(String unitCode);

    int getMaxCode();

}