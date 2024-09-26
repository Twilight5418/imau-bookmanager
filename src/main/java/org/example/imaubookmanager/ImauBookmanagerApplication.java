package org.example.imaubookmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.imaubookmanager.dao") // 替换为你的 DAO 包名
public class ImauBookmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImauBookmanagerApplication.class, args);
    }

}
