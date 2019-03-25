package com.oocl.ita.gallery.common.model;

import java.util.List;

/**
 * 资源与操作权限集合类定义JsonPermissions
 */
public class JsonPermissions {

    private List<SimplePermission> permissions;

    public List<SimplePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SimplePermission> permissions) {
        this.permissions = permissions;
    }
}
/**
 * [
 *   {
 *     "resourceId":"permission",
 *     "resourceName":"权限",
 *     "privileges": {
 *       "read":"查看",
 *       "write":"新增",
 *       "update":"更新",
 *       "delete":"删除"
 *     }
 *   },
 *   {
 *     "resourceId":"user",
 *     "resourceName":"用户",
 *     "privileges": {
 *       "read":"查看用户列表",
 *       "write":"新增用户",
 *       "import":"导入用户",
 *       "update":"修改用户信息",
 *       "delete":"删除用户"
 *     }
 *   }
 * ]
 */