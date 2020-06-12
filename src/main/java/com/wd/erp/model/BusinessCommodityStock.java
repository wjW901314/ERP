package com.wd.erp.model;

import java.math.BigDecimal;

public class BusinessCommodityStock {
    private String id;
    private String commodityCode;
    private String commodityName;
    private String commoditySpell;
    private String largeUnit;
    private String smallUnit;
    private String specCode;
    private String specName;
    private String supplierCode;
    private String supplierName;
    private String typeCode;
    private String typeName;
    private double totalPrice;
    private Integer inventory;
    private double price;
    private Integer minimumInventory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getLargeUnit() {
        return largeUnit;
    }

    public void setLargeUnit(String largeUnit) {
        this.largeUnit = largeUnit;
    }

    public String getSmallUnit() {
        return smallUnit;
    }

    public void setSmallUnit(String smallUnit) {
        this.smallUnit = smallUnit;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getMinimumInventory() {
        return minimumInventory;
    }

    public void setMinimumInventory(Integer minimumInventory) {
        this.minimumInventory = minimumInventory;
    }
}