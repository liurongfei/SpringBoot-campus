package cn.edu.jxnu.rj.lrf.service;

public interface LikeService {

    void MomentLike(int momentId,int userId);

    /**
     * @Description //TODO 评论点赞
     * @Param [commentId, userId]
     * @return void
     **/
    void CommentLike(int commentId,int userId);
}
