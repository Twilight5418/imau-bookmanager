package org.example.imaubookmanager.service.impl;

import org.example.imaubookmanager.dao.UserDao;
import org.example.imaubookmanager.pojo.Response;
import org.example.imaubookmanager.pojo.User;
import org.example.imaubookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Response<User> registerUser(User user) {
        try {
            logger.info("开始注册用户: {}", user.getUsername());

            // 检查用户名是否已存在
            User existingUser = userDao.findByUsername(user.getUsername());
            if (existingUser != null) {
                logger.warn("用户已存在: {}", user.getUsername());
                return new Response<>(400, "用户已存在", null); // 返回用户已存在的响应
            }

            // 插入用户
            int result = userDao.insertUser(user);
            logger.info("插入用户结果: {}", result);

            return new Response<>(200, "用户注册成功", user); // 成功时返回用户信息
        } catch (Exception e) {
            logger.error("用户注册失败: {}", e.getMessage());
            return new Response<>(500, "用户注册失败，系统错误", null); // 发生异常时返回错误信息
        }
    }
}
