package org.example.imaubookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role {
    private int roleId;            // 自增主键
    private String roleName;       // 角色名称
    private String roleUserName;   // 角色用户名
}
