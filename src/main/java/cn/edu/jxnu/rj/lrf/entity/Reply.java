package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Reply {
    /**
     * 回复id
     * reply_id
     */
    private Integer replyId;

    /**
     * 评论id
     * comment_id
     */
    private Integer commentId;

    /**
     * 回复内容
     * reply_content
     */
    private String replyContent;

    /**
     * 回复用户id
     * user_id1
     */
    private Integer userId1;

    /**
     * 被回复用户id
     * user_id2
     */
    private Integer userId2;

    /**
     * 创建时间
     * gmt_create
     */
    private Date gmtCreate;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Integer getUserId1() {
        return userId1;
    }

    public void setUserId1(Integer userId1) {
        this.userId1 = userId1;
    }

    public Integer getUserId2() {
        return userId2;
    }

    public void setUserId2(Integer userId2) {
        this.userId2 = userId2;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}