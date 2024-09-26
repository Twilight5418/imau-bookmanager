package org.example.imaubookmanager.service;

import org.example.imaubookmanager.pojo.Response;
import org.example.imaubookmanager.pojo.User;
import java.util.List;

public interface UserService {
   Response<User> registerUser(User user);  // 注册新用户
   String login(User user); // 新增登录方法，返回 Token
}
