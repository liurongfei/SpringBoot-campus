package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname ResponseController
 * @Description TODO 响应控制
 * @Date 2021/5/13 19:22
 * @Created by 刘荣飞
 */
@RestController
@RequestMapping("/response")
public class ResponseController {

    @RequestMapping("/NotLogin")
    public ResponseModel notLogin(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", ErrorCodeEnum.USER_NOT_LOGIN.getCode());
        map.put("message",ErrorCodeEnum.USER_NOT_LOGIN.getMsg());
        return new ResponseModel(ResponseModel.STATUS_FAILURE,map);
    }
}
