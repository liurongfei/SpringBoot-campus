package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.UserService;
import cn.edu.jxnu.rj.lrf.util.Util;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @title: UserController
 * @description TODO 用户相关操作
 * @author liu rong fei
 * @date: 2021/3/28 14:30
 */
@RestController
@RequestMapping("/user")
public class UserController{
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
    public ResponseModel register(String code, User user, HttpServletRequest request){
        String c = null;
        try {
            c = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        } catch (NullPointerException e) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"请获取验证码");
        }
        if(!StringUtils.equals(c,code)){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"验证码不正确");
        }
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
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"验证码不正确");
        }
        if(StringUtils.isEmpty(userPhone) || StringUtils.isEmpty(userPassword)){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数不合法");
        }

        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(userPhone,userPassword));

        User user = (User)subject.getPrincipal();
        int id = user.getUserId();
//        String token = Util.createToken(id+"");//使用JWT
        String token = UUID.randomUUID().toString().replace("-","");
        redisTemplate.opsForValue().set(token,user,1, TimeUnit.DAYS);//token保存1天

        return new ResponseModel("token");
    }

    /**
     * @author lrf
     * @description //TODO 用户注销
     * @date 2021/3/30 14:37
     * @param request 从请求头中获取token
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/logout")
    public ResponseModel logout(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(StringUtils.isNotEmpty(token)){
            redisTemplate.delete(token);
        }
        SecurityUtils.getSubject().logout();
        return new ResponseModel();
    }

    /**
     * @author lrf
     * @description //TODO 获取用户信息
     * @date 2021/4/16 21:09
     * @param request 从请求头中获取token,根据token获取用户信息
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/status")
    public ResponseModel getUser(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        User user =null;
        if(StringUtils.isNotEmpty(token)){
            user = (User) redisTemplate.opsForValue().get(token);
        }
        return new ResponseModel(user);
    }

    @GetMapping("/getAll")
    @RequiresRoles("admin")
    @RequiresPermissions("user:*")
    public ResponseModel getAll(){
        List<User> list = userService.getALl();

        return new ResponseModel(list);
    }
}
