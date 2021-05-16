package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Comment;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * @Description //TODO  通过作品id查找该作品下的所以评论
     * @Param [CommentId]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Comment>
     **/
    List<Comment> selectByCommentId(int MomentId);
}