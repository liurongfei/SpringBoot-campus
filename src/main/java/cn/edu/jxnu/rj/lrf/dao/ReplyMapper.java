package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);

    List<Reply> selectByCommentId(int commentId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}