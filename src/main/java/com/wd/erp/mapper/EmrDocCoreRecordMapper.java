package com.wd.erp.mapper;

import com.wd.erp.model.EmrDocCoreRecode;
import com.wd.erp.model.EmrDocCoreRecodeWithBLOBs;

public interface EmrDocCoreRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmrDocCoreRecodeWithBLOBs record);

    int insertSelective(EmrDocCoreRecodeWithBLOBs record);

    EmrDocCoreRecodeWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmrDocCoreRecodeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EmrDocCoreRecodeWithBLOBs record);

    int updateByPrimaryKey(EmrDocCoreRecode record);
}