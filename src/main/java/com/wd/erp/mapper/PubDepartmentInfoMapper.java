package com.wd.erp.mapper;

import com.wd.erp.model.PubDepartmentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PubDepartmentInfoMapper {
    int deleteByPrimaryKey(String departCode);

    int insert(PubDepartmentInfo record);

    int insertSelective(PubDepartmentInfo record);

    PubDepartmentInfo selectByPrimaryKey(String departCode);

    int updateByPrimaryKeySelective(PubDepartmentInfo record);

    int updateByPrimaryKeyWithBLOBs(PubDepartmentInfo record);

    int updateByPrimaryKey(PubDepartmentInfo record);

    List<PubDepartmentInfo> getAll(@Param("keyWord") String keyWord);

    int getMaxCode();
}