package cn.edu.jxnu.rj.lrf.dto;

import cn.edu.jxnu.rj.lrf.entity.Moments;

import java.util.Date;

/**
 * @author liu rong fei
 * @title: DynamicDTO
 * @description:
 * @date: 2021/4/17 20:06
 */
public class MomentsDto extends Moments {
    /**
     * 动态id
     * moment_id
     */
    private Integer momentId;

    /**
     * 用户id
     * user_id
     */
    private Integer userId;

    /**
     * 动态内容
     * moment_content
     */
    private String momentContent;

    /**
     * 动态状态： 0公开1匿名
     * moment_status
     */
    private Integer momentStatus;

    /**
     * 创建时间
     * gmt_create
     */
    private Date gmtCreate;

    //用户名
    private String userName;

    //用户头像路径
    private String userImage;

    //用户学校
    private String userSchool;

    //点赞数
    private Integer likeNum;

    //评论数
    private Integer commentNum;

    //转发数
    private Integer forwardNum;

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

    public String getMomentContent() {
        return momentContent;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent == null ? null : momentContent.trim();
    }

    public Integer getMomentStatus() {
        return momentStatus;
    }

    public void setMomentStatus(Integer momentStatus) {
        this.momentStatus = momentStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
    }
}
