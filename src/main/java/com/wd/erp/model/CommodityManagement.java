package com.wd.erp.model;
/*
商品管理实体
 */
public class CommodityManagement {
    private String id;

    private String commodityName;

    private String commoditySpell;

    private Integer commoditySpec;

    private Integer commoditySupplier;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommoditySpell() {
        return commoditySpell;
    }

    public void setCommoditySpell(String commoditySpell) {
        this.commoditySpell = commoditySpell;
    }

    public Integer getCommoditySpec() {
        return commoditySpec;
    }

    public void setCommoditySpec(Integer commoditySpec) {
        this.commoditySpec = commoditySpec;
    }

    public Integer getCommoditySupplier() {
        return commoditySupplier;
    }

    public void setCommoditySupplier(Integer commoditySupplier) {
        this.commoditySupplier = commoditySupplier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}