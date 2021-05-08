package cn.edu.jxnu.rj.lrf.interceptor;

import cn.edu.jxnu.rj.lrf.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liu rong fei
 * @title: LoginInterceptor
 * @description:
 * @date: 2021/4/16 20:06
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorization");
        logger.info(request.getRequestURI());
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login")){
            return true;
        }
        //判断请求头中是否有token
        if(authorization!=null){
            boolean verify = Util.verifyToken
                    (authorization);
            //判断校验后的token是否有效
            if(verify){
                logger.info("token is valid");
                return true;
            }else {
                logger.info("token is invalid");
                return false;
            }
        }else {
            logger.info("token isn't exists");
            return false;
        }
    }
}
