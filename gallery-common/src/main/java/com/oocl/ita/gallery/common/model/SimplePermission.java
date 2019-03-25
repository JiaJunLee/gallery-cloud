package com.oocl.ita.gallery.common.model;

import java.util.Map;

public class SimplePermission {

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 资源名
     */
    private String resourceName;

    /**
     * 权限列表
     */
    private Map<String, String> privileges;

    /**
     * 是否被遗弃
     */
    private boolean abandon = false;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

    public boolean isAbandon() {
        return abandon;
    }

    public void setAbandon(boolean abandon) {
        this.abandon = abandon;
    }
}