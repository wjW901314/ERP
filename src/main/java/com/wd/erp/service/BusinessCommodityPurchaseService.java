package com.wd.erp.service;

import com.wd.erp.model.BusinessCommodityPurchase;
import com.wd.erp.model.ResultJson;

public interface BusinessCommodityPurchaseService {
    ResultJson getAll(String keyWord);
    ResultJson addCommodityPurchase(BusinessCommodityPurchase record);
    ResultJson modifyCommodityPurchase(BusinessCommodityPurchase record);
    ResultJson deleteCommodityPurchase(String purchaseCode);
    ResultJson auditVoidRecord(String id,String status);
}
