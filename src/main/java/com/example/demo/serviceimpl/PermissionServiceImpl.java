package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    // Save a new Permission
    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    // Get all Permissions
    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    // Get Permission by ID
    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with ID: " + id));
    }

    // Get Permissions by Role ID
    @Override
    public List<Permission> getPermissionsByRoleId(Long roleId) {
        return permissionRepository.findByPerRole_RoleId(roleId);
    }

    // Update an existing Permission
    @Override
    public Permission updatePermission(Long id, Permission permissionDetails) {
        Permission existingPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with ID: " + id));
        
        existingPermission.setPerRole(permissionDetails.getPerRole());
        existingPermission.setPerModule(permissionDetails.getPerModule());
        existingPermission.setPerName(permissionDetails.getPerName());
        
        return permissionRepository.save(existingPermission);
    }

    // Delete a Permission by ID
    @Override
    public void deletePermission(Long id) {
        if (!permissionRepository.existsById(id)) {
            throw new RuntimeException("Permission not found with ID: " + id);
        }
        permissionRepository.deleteById(id);
    }
}
