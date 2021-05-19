package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.*;
import cn.edu.jxnu.rj.lrf.entity.Comment;
import cn.edu.jxnu.rj.lrf.entity.Notice;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.CommentService;
import cn.edu.jxnu.rj.lrf.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentMapper commentMapper;

    @Override
    public void post(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void delete(int commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public List<Comment> getAllByCommentId(int momentId) {

        return commentMapper.selectByCommentId(momentId);
    }
}
