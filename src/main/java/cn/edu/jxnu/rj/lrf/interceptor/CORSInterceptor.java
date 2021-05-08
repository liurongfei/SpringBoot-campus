package cn.edu.jxnu.rj.lrf.interceptor;

import cn.edu.jxnu.rj.lrf.common.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liu rong fei
 * @title: CORSInterceptor
 * @description: TODO 跨域请求
 * @date: 2021/4/16 15:49
 */
@Component
public class CORSInterceptor implements HandlerInterceptor, ErrorCode {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("cross..."+request.getRequestURI());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, authorization, X-Requested-With");
        response.setHeader("Access-Control-Expose-Headers", "authorization");
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            response.setStatus(200);
            return false;//通过所有OPTION请求
        }
        return true;
    }
}
