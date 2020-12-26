package com.ws.bighomeworkfirst.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.bighomeworkfirst.util.JWTutils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTinterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        try {
            JWTutils.verify(token);//验证
            return true;//放行
        }catch (Exception e) {
            map.put("msg", e.getMessage());
        }
        map.put("state",false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
