package com.lpr.afsol.LPR.Reads.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

@Entity
public class Role {
    @NotNull
    @Id
    private String roleName;
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }
}
