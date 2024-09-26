package org.example.imaubookmanager.controller;

import org.example.imaubookmanager.pojo.Response;
import org.example.imaubookmanager.pojo.User;
import org.example.imaubookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author 17662
 * @date 2024/9/25
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册用户
    //@RequestBody 注解表示从客户端的 HTTP 请求体 中获取 JSON 数据，并将这些数据映射成一个 User 对象。
    @PostMapping("/register")
    public Response<User> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    // 登录用户
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.login(user);
    }
}