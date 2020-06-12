package com.wd.erp.mapper;

import com.wd.erp.model.EmrDocCordRecordComments;
import com.wd.erp.model.EmrDocCordRecordCommentsWithBLOBs;

public interface EmrDocCordRecordCommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmrDocCordRecordCommentsWithBLOBs record);

    int insertSelective(EmrDocCordRecordCommentsWithBLOBs record);

    EmrDocCordRecordCommentsWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmrDocCordRecordCommentsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EmrDocCordRecordCommentsWithBLOBs record);

    int updateByPrimaryKey(EmrDocCordRecordComments record);
}