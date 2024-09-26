package org.example.imaubookmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.imaubookmanager.pojo.User;
import java.util.List;
@Mapper
public interface UserDao {
    int insertUser(User user);  // 插入用户,方法接收一个 User 对象作为参数，用来插入用户数据。,int 体现的是插入操作执行后，数据库中实际影响了多少行数据。

    User findByUsername(String username);  // 根据用户名查找用户

}
