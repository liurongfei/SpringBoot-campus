package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import cn.edu.jxnu.rj.lrf.service.MomentsService;
import com.alibaba.druid.wall.violation.ErrorCode;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/post")
    public ResponseModel post(Moments moments){
        if (moments ==null){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        return new ResponseModel();
    }


    /**
     * @Description //TODO 查看所有帖子
     * @Param []
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/getAll")
    public ResponseModel getMoment(){
        return new ResponseModel();
    }

    @GetMapping("/getByUserId")
    public ResponseModel getByUserId(Integer userId){
        if (userId <=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        List<Moments> list = momentsService.getAllByUserId(userId);
        return new ResponseModel(list);
    }
    /**
     * @Description //TODO  通过momentId删除单条动态
     * @Param [momentId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/deleteByMomentId")
    public ResponseModel deleteByMomentId(int momentId){
        if(momentId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        momentsService.deleteByMomentId(momentId);
        return new ResponseModel();
    }
    /**
     * @Description //TODO  通过momentId查找单条动态
     * @Param [momentId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/findById")
    public ResponseModel findById(int momentId){
        if(momentId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        Moments moments = momentsService.findById(momentId);
        return new ResponseModel(moments);
    }
}
