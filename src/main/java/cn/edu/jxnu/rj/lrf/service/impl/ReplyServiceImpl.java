package cn.edu.jxnu.rj.lrf.service.impl;


import cn.edu.jxnu.rj.lrf.dao.*;
import cn.edu.jxnu.rj.lrf.entity.Reply;
import cn.edu.jxnu.rj.lrf.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    ReplyMapper replyMapper;

    /**
     * @Description //TODO  回复
     * @Param [reply]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Reply>
     **/
    @Override
    public List<Reply> post(Reply reply) {
        replyMapper.insert(reply);
        return null;
    }


    /**
     * @Description //TODO  删除回复
     * @Param [replyId]
     * @return void
     **/
    @Override
    public void deleteReply(int replyId) {
        replyMapper.deleteByPrimaryKey(replyId);
    }


    /**
     * @Description //TODO  通过评论id得到该评论下所有回复
     * @Param [commentId]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Reply>
     **/
    @Override
    public List<Reply> getAllInComment(int commentId) {

        System.out.println(replyMapper.selectByPrimaryKey(commentId));
       return (List<Reply>) replyMapper.selectByPrimaryKey(commentId);
    }
}
