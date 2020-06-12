package com.wd.erp.model;

public class PubUserInfo {
    private String userCode;

    private String departCode;

    private String roleCoed;

    private String userName;

    private String userSpell;

    private String password;

    private Integer status;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getRoleCoed() {
        return roleCoed;
    }

    public void setRoleCoed(String roleCoed) {
        this.roleCoed = roleCoed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSpell() {
        return userSpell;
    }

    public void setUserSpell(String userSpell) {
        this.userSpell = userSpell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}