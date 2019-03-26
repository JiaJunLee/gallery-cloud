package com.oocl.ita.gallery.common.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "role")
public class Role extends BaseDocument {

    private String name;
    private String nickname;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
