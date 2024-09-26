package org.example.imaubookmanager.service.impl;

import org.example.imaubookmanager.dao.RoleDao;
import org.example.imaubookmanager.pojo.Role;
import org.example.imaubookmanager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(int id) {
        return roleDao.selectRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.selectAllRoles();
    }

    @Override
    public int createRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRoleById(int id) {
        return roleDao.deleteRoleById(id);
    }
}
