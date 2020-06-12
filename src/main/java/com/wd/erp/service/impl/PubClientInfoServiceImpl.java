package com.wd.erp.service.impl;

import com.wd.erp.mapper.PubClientInfoMapper;
import com.wd.erp.model.PubClientInfo;
import com.wd.erp.model.ResultJson;
import com.wd.erp.service.PubClientInfoService;
import com.wd.erp.until.SystemSettingUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.String.format;

@Service
public class PubClientInfoServiceImpl implements PubClientInfoService {

    @Autowired
    PubClientInfoMapper clientInfoMapper;

    @Autowired
    SystemSettingUntil systemSettingUntil;


    @Override
    public ResultJson getAll(String keyWord) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        List<PubClientInfo> list = clientInfoMapper.getAll(keyWord);
        if (list != null) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
            resultJson.setData(list);
        }
        return resultJson;
    }

    @Override
    public ResultJson addClientInfo(PubClientInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("查询失败!");
        int maxCode = clientInfoMapper.getMaxCode() + 1;
        record.setCode(format(systemSettingUntil.getCodeLong5(), maxCode));
        int i = clientInfoMapper.insert(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("查询成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson modifyClientInfo(PubClientInfo record) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("修改失败!");
        if(StringUtils.isEmpty(record.getCode())){
            resultJson.setMsg("客户编码不能为空！");
            return resultJson;
        }
        int i = clientInfoMapper.updateByPrimaryKey(record);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("修改成功!");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteClientInfo(String clientCode) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(-1);
        resultJson.setSuccess(false);
        resultJson.setMsg("删除失败!");
        if(StringUtils.isEmpty(clientCode)){
            resultJson.setMsg("客户编码不能为空！");
            return resultJson;
        }
        int i = clientInfoMapper.deleteByPrimaryKey(clientCode);
        if (i > 0) {
            resultJson.setCode(0);
            resultJson.setSuccess(true);
            resultJson.setMsg("删除成功!");
        }
        return resultJson;
    }
}
