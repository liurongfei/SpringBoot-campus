package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Like extends LikeKey {
    /**
     * 创建时间
     * gmt_create
     */
    private Date gmtCreate;

    /**
     * 修改时间
     * gmt_modified
     */
    private Date gmtModified;

    /**
     * 是否点赞
     * isLike
     */
    private Boolean islike;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getIslike() {
        return islike;
    }

    public void setIslike(Boolean islike) {
        this.islike = islike;
    }
}