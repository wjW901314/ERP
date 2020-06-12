package com.wd.erp.model;

public class PubCommoditySpec {
    private String specCode;

    private String specName;

    private String specSpell;

    private Integer status;

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecSpell() {
        return specSpell;
    }

    public void setSpecSpell(String specSpell) {
        this.specSpell = specSpell;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}