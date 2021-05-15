package cn.edu.jxnu.rj.lrf.controller.advice;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: ExceptionAdvice
 * @description:
 * @Author liu rong fei
 * @Date: 2021/3/28 14:31
 */
@RestControllerAdvice
public class ExceptionAdvice {
    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = BusinessException.class)
    public ResponseModel handleBusinessException(BusinessException e){
        Map<Object, Object> data = new HashMap<>();
        data.put("code",e.getCode());
        data.put("message",e.getMessage());
        logger.debug("BusinessException:"+e.getMessage());
        return new ResponseModel(ResponseModel.STATUS_FAILURE,data);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseModel noHandleException(NoHandlerFoundException e){
        Map<Object, Object> data = new HashMap<>();
        data.put("code", ErrorCodeEnum.UNDEFINED_ERROR.getCode());
        data.put("message","该资源不存在");
        logger.debug("noHandleException:");
        return new ResponseModel(ResponseModel.STATUS_FAILURE,data);
    }

    @ExceptionHandler(value = ShiroException.class)
    public ResponseModel handleException(ShiroException e){
        Map<Object, Object> data = new HashMap<>();
        if(e instanceof UnknownAccountException || e instanceof IncorrectCredentialsException){
            data.put("code", ErrorCodeEnum.USER_LOGIN_FAILURE.getCode());
            data.put("message","账号或密码错误");
        }

        return new ResponseModel(ResponseModel.STATUS_FAILURE,data);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseModel handleException(Exception e){
        Map<Object, Object> data = new HashMap<>();
        data.put("code", ErrorCodeEnum.UNDEFINED_ERROR.getCode());
        data.put("message","发生未知错误:"+e.getMessage());
        logger.debug("Exception:");
        return new ResponseModel(ResponseModel.STATUS_FAILURE,data);
    }
}
