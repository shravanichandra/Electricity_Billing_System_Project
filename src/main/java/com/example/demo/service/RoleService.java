package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
    void deleteRoleById(Long id);
}
