package com.wd.erp.mapper;

import com.wd.erp.model.PubSupplierInfo;

import java.util.List;

public interface PubSupplierInfoMapper {
    int deleteByPrimaryKey(String code);

    int insert(PubSupplierInfo record);

    int insertSelective(PubSupplierInfo record);

    PubSupplierInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PubSupplierInfo record);

    int updateByPrimaryKeyWithBLOBs(PubSupplierInfo record);

    int updateByPrimaryKey(PubSupplierInfo record);

    List<PubSupplierInfo> getAll(String keyWord);

    int getMaxCode();

}