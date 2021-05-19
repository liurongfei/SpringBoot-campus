package cn.edu.jxnu.rj.lrf.service;

public interface LikeService {
    /**
     * @Description //TODO 动态点赞
     * @Param [momentId, userId]
     * @return void
     **/
    void MomentLike(int momentId,int userId);

    /**
     * @Description //TODO 评论点赞
     * @Param [commentId, userId]
     * @return void
     **/
    void CommentLike(int commentId,int userId);

    /**
     * @Description //TODO 取消动态点赞
     * @Param [momentId, userId]
     * @return void
     **/
    void cancelMomentLike(int momentId,int userId);

    /**
     * @Description //TODO 取消评论点赞
     * @Param [commentId, userId]
     * @return void
     **/
    void cancelCommentLike(int commentId,int userId);

    /**
     * @Description //TODO 判断该用户是否点赞了该评论
     * @Param [commentId, userId]
     * @return boolean
     **/
    boolean isCommentLike(int commentId,int userId);

    /**
     * @Description //TODO 判断该用户是否点赞了该动态
     * @Param [momentId, userId]
     * @return boolean
     **/
    boolean isMomentLike(int momentId,int userId);

    /**
     * @Description //TODO 查看该动态点赞数目
     * @Param [momentId]
     * @return void
     **/
    long getMomentLikeAmount(int momentId);

    /**
     * @Description //TODO 查看该评论的点赞数目
     * @Param [commentId]
     * @return long
     **/
    long getCommentLikeAmount(int commentId);


}
