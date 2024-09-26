package org.example.imaubookmanager.service.impl;

import org.example.imaubookmanager.dao.UserDao;
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
    public String registerUser(User user) {

        try {
            // 你的逻辑代码
            logger.info("开始注册用户: {}", user.getUsername());

            // 检查用户名是否已存在
            User existingUser = userDao.findByUsername(user.getUsername());
            if (existingUser != null) {
                logger.warn("用户已存在: {}", user.getUsername());
                return "用户已存在";
            }

            // 插入用户
            int result = userDao.insertUser(user);
            logger.info("插入用户结果: {}", result);
            return "用户注册成功";
        } catch (Exception e) {
            e.printStackTrace(); // 打印完整的异常堆栈信息
            return "用户注册失败";
        }

    }
}
