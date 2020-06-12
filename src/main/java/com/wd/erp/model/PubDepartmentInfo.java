package com.wd.erp.model;

public class PubDepartmentInfo {
    private String departCode;

    private String departName;

    private String departSpell;

    private Integer status;

    private String remarks;

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartSpell() {
        return departSpell;
    }

    public void setDepartSpell(String departSpell) {
        this.departSpell = departSpell;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}