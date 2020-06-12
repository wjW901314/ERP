package com.wd.erp.model;

public class CommodityMonthSale {
    private String commodityName;
    private String saleNumber;
    private String salePrice;
    private String saleTotalPrice;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(String saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }
}
