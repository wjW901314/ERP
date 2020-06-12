package com.wd.erp.model;

public class DictUserRole {
    private String id;

    private String roleName;

    private String roleSpell;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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