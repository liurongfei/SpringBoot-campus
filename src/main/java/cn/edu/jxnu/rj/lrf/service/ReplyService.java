package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> post(Reply reply);//回复
    void deleteReply(int replyId);//删除回复
    List<Reply> getAllInComment(int commentId);//获取评论下的所有回复
}
