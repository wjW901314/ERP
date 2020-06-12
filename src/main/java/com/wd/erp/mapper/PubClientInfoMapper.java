package com.wd.erp.mapper;

import com.wd.erp.model.PubClientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PubClientInfoMapper {
    int deleteByPrimaryKey(String code);

    int insert(PubClientInfo record);

    int insertSelective(PubClientInfo record);

    PubClientInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PubClientInfo record);

    int updateByPrimaryKeyWithBLOBs(PubClientInfo record);

    int updateByPrimaryKey(PubClientInfo record);

    List<PubClientInfo> getAll(@Param("keyWord") String keyWord);

    int getMaxCode();

}