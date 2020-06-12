package com.wd.erp.model;

public class PubUserRoleInfo {
    private String roleCoed;

    private String departCode;

    private String roleName;

    private String roleSpell;

    private Integer status;

    public String getRoleCoed() {
        return roleCoed;
    }

    public void setRoleCoed(String roleCoed) {
        this.roleCoed = roleCoed;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSpell() {
        return roleSpell;
    }

    public void setRoleSpell(String roleSpell) {
        this.roleSpell = roleSpell;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}