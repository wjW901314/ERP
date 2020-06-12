package com.wd.erp.model;

public class CommoditySaleInfoHistogramReport {
    /*月份*/
    private String[] months;
    /*进货数量*/
    private Integer[] purchaseNumber;
    /*销售数量*/
    private Integer[] saleNumber;

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public Integer[] getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer[] purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Integer[] getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer[] saleNumber) {
        this.saleNumber = saleNumber;
    }
}
