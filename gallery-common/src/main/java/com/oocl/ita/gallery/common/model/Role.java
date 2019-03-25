package com.oocl.ita.gallery.common.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "role")
public class Role extends BaseDocument {

    /**
     * 角色名，用于权限校验
     */
    private String name;

    /**
     * 角色中文名，用于显示
     */
    private String nickname;

    /**
     * 角色描述信息
     */
    private String description;

    /**
     * 角色可进行的操作列表
     */
    private List<SimplePermission> permissions;

    /**
     * Spring Security 4.0以上版本角色都默认以'ROLE_'开头
     * @param name
     */
    public void setName(String name) {
        if (!name.contains("ROLE_")) {
            this.name = "ROLE_" + name;
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SimplePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SimplePermission> permissions) {
        this.permissions = permissions;
    }
}
