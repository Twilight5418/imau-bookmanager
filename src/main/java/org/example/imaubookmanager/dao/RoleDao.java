package org.example.imaubookmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.imaubookmanager.pojo.Role;
import java.util.List;
@Mapper
public interface RoleDao {

    // 根据 ID 查询角色
    Role selectRoleById(int roleId);

    // 查询所有角色
    List<Role> selectAllRoles();

    // 插入新角色
    int insertRole(Role role);

    // 更新角色信息
    int updateRole(Role role);

    // 根据 ID 删除角色
    int deleteRoleById(int roleId);
}
