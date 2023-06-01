package com.eduthrill.codelyser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="role")
    private Set<UserRole> userRoles=new HashSet<>();

    public Role() {
        super();

    }


    public Role(Long roleId, String roleName, Set<UserRole> userRoles) {
        super();
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Set<UserRole> getUserRoles() {
        return userRoles;
    }


    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }





}
