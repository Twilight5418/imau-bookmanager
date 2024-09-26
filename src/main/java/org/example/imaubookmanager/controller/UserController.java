package org.example.imaubookmanager.controller;

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

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        //@RequestBody 注解表示从客户端的 HTTP 请求体 中获取 JSON 数据，并将这些数据映射成一个 User 对象。
        return userService.registerUser(user);//这个方法的返回类型是 String，意味着该方法返回一个字符串
    }
}