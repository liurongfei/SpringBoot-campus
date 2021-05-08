package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCode;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.util.Util;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.UserService;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * @title: UserController
 * @description TODO 用户相关操作
 * @author liu rong fei
 * @date: 2021/3/28 14:30
 */
@RestController
@RequestMapping("/user")
public class UserController implements ErrorCode {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * @author lrf
     * @description //TODO 注册用户
     * @date 2021/3/30 14:36
     * @param code, user, session]验证码 注册用户信息 session域
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/register")
    public ResponseModel register(String code, User user, HttpSession session){
        String c = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        if(!StringUtils.equals(c,code)){
            throw new BusinessException(PARAMETER_ERROR,"验证码不正确");
        }
        user.setUserPassword(Util.md5(user.getUserPassword()));

        userService.register(user);

        return new ResponseModel();
    }

    /**
     * @author lrf
     * @description //TODO 用户登录
     * @date 2021/3/30 14:37
     * @param userPhone, userPassword 用户名 用户密码
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/login")
    public ResponseModel login(String code, String userPhone, String userPassword, HttpServletRequest request, HttpServletResponse response){
        String c = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!StringUtils.equals(c,code)){
            throw new BusinessException(PARAMETER_ERROR,"验证码不正确");
        }
        if(StringUtils.isEmpty(userPhone) || StringUtils.isEmpty(userPassword)){
            throw new BusinessException(PARAMETER_ERROR,"参数不合法");
        }

        String md5 = Util.md5(userPassword);
        logger.info(md5);
        System.out.println(md5);
        User user = userService.login(userPhone, md5);
        int id = user.getUserId();
        String token = Util.createToken(id+"");
        redisTemplate.opsForValue().set(token,user,1, TimeUnit.DAYS);//token保存1天

        return new ResponseModel(token);
    }

    /**
     * @author lrf
     * @description //TODO 用户注销
     * @date 2021/3/30 14:37
     * @param request session 用户id
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/logout")
    public ResponseModel logout(HttpServletRequest request){
//        session.invalidate();
        String token = request.getHeader("Authorization");
        if(StringUtils.isNotEmpty(token)){
            redisTemplate.delete(token);
        }
        return new ResponseModel();
    }

    /**
     * @author lrf
     * @description //TODO
     * @date 2021/4/16 21:09
     * @param
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping(path = "/status", method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel getUser(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        User user =null;
        if(StringUtils.isNotEmpty(token)){
            user = (User) redisTemplate.opsForValue().get(token);
        }
        return new ResponseModel(user);
    }
}
