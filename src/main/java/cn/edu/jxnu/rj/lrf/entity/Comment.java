package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Comment {
    /**
     * 评论id
     * comment_id
     */
    private Integer commentId;

    /**
     * 帖子id
     * moment_id
     */
    private Integer momentId;

    /**
     * 评论的用户id
     * user_id
     */
    private Integer userId;

    /**
     * 评论内容
     * comment_content
     */
    private String commentContent;

    /**
     * 创建时间
     * gmt_create
     */
    private Date gmtCreate;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}