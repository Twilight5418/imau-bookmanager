package org.example.imaubookmanager.interceptor;

/**
 * @author 17662
 * @date 2024/9/26
 */
import org.example.imaubookmanager.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Claims;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private JwtUtil jwtUtil;

    // 构造方法注入 JwtUtil
    public JwtInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    //        HttpServletRequest request：表示客户端发来的请求，包含请求的详细信息，供你在拦截器中使用。
//        HttpServletResponse response：表示服务器返回的响应，可以通过它设置响应的状态和内容。
//        Object handler：表示控制器中的目标方法，你可以根据它决定是否处理某些特定的方法。
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 从请求头中获取 Authorization
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // 获取 token
            String token = authorizationHeader.substring(7);//去掉bearer部分
            try {
                // 验证 token 并提取用户信息
                Claims claims = jwtUtil.parseToken(token);

                // 将用户信息放入请求中，供后续处理使用
                request.setAttribute("userClaims", claims);
                return true;  // 继续处理请求
            } catch (Exception e) {
                // 如果 token 验证失败，返回 401 错误
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return false;
            }
        }

        // 如果没有 token，直接返回 401 错误
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing token");
        return false;
    }
}
