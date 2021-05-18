package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LikeController
 * @Description TODO 点赞操作请求
 * @Date 2021/5/17 9:23
 * @Created by 傅联强
 */
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/moment")
    public ResponseModel momentLike(int momentId,int userId){
        likeService.MomentLike(momentId,userId);
        return new ResponseModel();
    }

    @PostMapping("/comment")
    public ResponseModel commentLike(int commentId, int userId){
        likeService.CommentLike(commentId,userId);
        return new ResponseModel();
    }

    @PostMapping("/cancelmoment")
    public ResponseModel cancelmomentLike(int momentId,int userId){
        likeService.cancelMomentLike(momentId,userId);
        return new ResponseModel();
    }

    @PostMapping("/cancelcomment")
    public ResponseModel cancelcommentLike(int commentId,int userId){
        likeService.cancelCommentLike(commentId,userId);
        return new ResponseModel();
    }

    @GetMapping("/ismoment")
    public ResponseModel isMomentLike(int momentId, int userId){
        boolean is = likeService.isMomentLike(momentId,userId);
        return new ResponseModel(is);
    }

    @GetMapping("/iscomment")
    public ResponseModel isCommentLike(int commentId,int userId){
        boolean is = likeService.isCommentLike(commentId,userId);
        return new ResponseModel(is);
    }

    @GetMapping("/momentlikeamount")
    public ResponseModel getMomentLikeAount(int momentId){
        long num = likeService.getMomentLikeAmount(momentId);
        return new ResponseModel(num);
    }

    @GetMapping("/commentlikeamount")
    public ResponseModel getCommentLikeAmount(int commentId){
        long num = likeService.getCommentLikeAmount(commentId);
        return new ResponseModel(num);
    }

}
