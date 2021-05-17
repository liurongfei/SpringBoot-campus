package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LikeController
 * @Description TODO 点赞操作请求
 * @Date 2021/5/17 9:23
 * @Created by 刘荣飞
 */
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @RequestMapping("/comment")
    public ResponseModel commentLike(int commentId, int userId){
        likeService.CommentLike(commentId,userId);

        return new ResponseModel();
    }
}
