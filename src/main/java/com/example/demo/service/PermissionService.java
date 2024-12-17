package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Permission;

public interface PermissionService {
    Permission savePermission(Permission permission);
    List<Permission> getAllPermissions();
    Permission getPermissionById(Long id);
    List<Permission> getPermissionsByRoleId(Long roleId);
    Permission updatePermission(Long id, Permission permissionDetails);
    void deletePermission(Long id);
}
