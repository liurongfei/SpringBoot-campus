package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Moments {
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
}