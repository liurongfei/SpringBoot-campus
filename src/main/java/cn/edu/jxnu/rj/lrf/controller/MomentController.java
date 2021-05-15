package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname MomentController
 * @Description TODO 帖子操作
 * @Date 2021/5/12 20:06
 * @Created by 刘荣飞
 */
@Controller
@RequestMapping("/moment")
public class MomentController {


    @RequestMapping("/")
    public ResponseModel getMoment(){
        return new ResponseModel();
    }

}
