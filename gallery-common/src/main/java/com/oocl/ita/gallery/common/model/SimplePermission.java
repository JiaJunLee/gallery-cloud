package com.oocl.ita.gallery.common.model;

import java.util.Map;

public class SimplePermission {

    private String resource;
    private String resourceName;
    private Map<String, String> privileges;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Map<String, String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Map<String, String> privileges) {
        this.privileges = privileges;
    }
}
