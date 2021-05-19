package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.Comment;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import cn.edu.jxnu.rj.lrf.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname CommentController
 * @Description TODO 评论操作请求
 * @Date 2021/5/15 20:02
 * @Created by 李发勇
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * @Description //TODO 发表评论
     * @Param [comment]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/postComment")
    public ResponseModel post(Comment comment){
        if (comment ==null){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        commentService.post(comment);
        return new ResponseModel();
    }

    /**
     * @Description //TODO  删除某一条评论
     * @Param [commentId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("deleteByCommentId")
    public ResponseModel deleteByCommentId(int commentId){
        if(commentId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        commentService.delete(commentId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO  通过作品id得到该作品下的所有评论
     * @Param [momentId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("getAllcomment")
    public ResponseModel getAllcomment(int momentId){
        if (momentId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        List<Comment> list = commentService.getAllByCommentId(momentId);
        return new ResponseModel(list);
    }

}
