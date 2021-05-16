package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.Reply;
import cn.edu.jxnu.rj.lrf.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname ReplyController
 * @Description TODO 回复表操作
 * @Date 2021/5/16 10:56
 * @Created by 李发勇
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    /**
     * @Description //TODO  回复评论
     * @Param [reply]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/replyPost")
    public ResponseModel reply(Reply reply){
        replyService.post(reply);
        return new ResponseModel();
    }

    /**
     * @Description //TODO 删除某一条回复
     * @Param [replyId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/deleteReply")
    public ResponseModel deleteReply(int replyId){
        replyService.deleteReply(replyId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO 获得该评论下的所有消息
     * @Param [commentId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/getAllByComment")
    public ResponseModel getAllInComment(int commentId){
        List<Reply> list= replyService.getAllInComment(commentId);
        return new ResponseModel(list);
    }

}
