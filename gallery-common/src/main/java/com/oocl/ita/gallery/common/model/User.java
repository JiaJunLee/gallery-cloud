package com.oocl.ita.gallery.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseDocument{

    /**
     * 用户登录名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户登录密码，用户的密码不应该暴露给客户端
     */
    @JsonIgnore
    private String password;

    private String type;

    /**
     * 用户在系统中的角色列表，将根据角色对用户操作权限进行限制
     */
    private List<String> roles = new ArrayList<>();

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}