package org.example.imaubookmanager.service;

import org.example.imaubookmanager.pojo.Role;
import java.util.List;

public interface RoleService {
    Role getRoleById(int id);
    List<Role> getAllRoles();
    int createRole(Role role);
    int updateRole(Role role);
    int deleteRoleById(int id);
}
