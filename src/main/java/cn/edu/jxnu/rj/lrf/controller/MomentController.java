package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import cn.edu.jxnu.rj.lrf.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname MomentController
 * @Description TODO 帖子操作
 * @Date 2021/5/12 20:06
 * @Created by 刘荣飞
 */
@RestController
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    MomentsService momentsService;

    /**
     * @Description //TODO 发表帖子
     * @Param [moments]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/post")
    public ResponseModel post(Moments moments){
        return new ResponseModel();
    }


    /**
     * @Description //TODO 查看所有帖子
     * @Param []
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/getAll")
    public ResponseModel getMoment(){

        return new ResponseModel();
    }

    @GetMapping("/getByUserId")
    public ResponseModel getByUserId(Integer userId){
        List<Moments> list = momentsService.getAllByUserId(userId);
        return new ResponseModel(list);
    }

}
