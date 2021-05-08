package cn.edu.jxnu.rj.lrf.controller.advice;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCode;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;

/**
 * @title: ExceptionAdvice
 * @description:
 * @Author liu rong fei
 * @Date: 2021/3/28 14:31
 */
@ControllerAdvice
public class ExceptionAdvice implements ErrorCode {
    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseModel handlerBusinessException(BusinessException e){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("message",e.getMessage());
        return new ResponseModel(ResponseModel.STATUS_FAILURE,map);
    }

    //系统异常
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResponseModel handleException(NoHandlerFoundException e){
        HashMap<Object, Object> map = new HashMap<>();
            map.put("code", UNDEFINED_ERROR);
            map.put("message", "该资源不存在！");
        return new ResponseModel(ResponseModel.STATUS_FAILURE,map);
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseModel handle(){
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("code", UNDEFINED_ERROR);
//        map.put("message", "发生未知错误！");
//        logger.debug("发生未知错误！");
//        return new ResponseModel(ResponseModel.STATUS_FAILURE,map);
//    }
}
