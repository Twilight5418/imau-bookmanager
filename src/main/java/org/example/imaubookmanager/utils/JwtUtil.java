package org.example.imaubookmanager.utils;

/**
 * @author 17662
 * @date 2024/9/26
 */
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component  // 添加这个注解
public class JwtUtil {

    private static final String SECRET_KEY = "kokoro"; // 替换为你的密钥

    // 生成 token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 设置 token 中的用户信息
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10*24)) // token 10小时有效
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用HS256加密算法
                .compact();
    }

    // 从 token 中解析用户名
    public static String extractUsername(String token) {
        return extractAllClaims(token).getSubject();//它是一个标准的JWT方法，不需要你自己定义。这个方法是由JWT库提供的，比如io.jsonwebtoken库。
    }

    // 验证 token 是否过期
    public static boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // 验证 token 是否有效
    public static boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    // 解析 token 中的所有声明
    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // 解析 token 并返回 Claims
    public Claims parseToken(String token) {
        try {
            // 使用密钥解析 JWT token
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            // 如果签名无效，抛出异常
            throw new RuntimeException("Invalid token signature");
        }
    }
}
