package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Notice {
    /**
     * 消息id
     * notice_id
     */
    private Integer noticeId;

    /**
     * 发送用户id
     * user_id1
     */
    private Integer userId1;

    /**
     * 接受用户id
     * user_id2
     */
    private Integer userId2;

    /**
     * 消息类型
     * notice_type
     */
    private Integer noticeType;

    /**
     * 消息内容
     * notice_content
     */
    private String noticeContent;

    /**
     * 消息发送时间
     * gmt_create
     */
    private Date gmtCreate;

    /**
     * 消息关联作品id
     * notice_linkId
     */
    private Integer noticeLinkid;

    /**
     * 消息关联作品类型:0动态1评论2回复
     * notice_linkType
     */
    private Integer noticeLinktype;

    /**
     * 已读状态：0未读默认  1已读
     * notice_read
     */
    private Integer noticeRead;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
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

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getNoticeLinkid() {
        return noticeLinkid;
    }

    public void setNoticeLinkid(Integer noticeLinkid) {
        this.noticeLinkid = noticeLinkid;
    }

    public Integer getNoticeLinktype() {
        return noticeLinktype;
    }

    public void setNoticeLinktype(Integer noticeLinktype) {
        this.noticeLinktype = noticeLinktype;
    }

    public Integer getNoticeRead() {
        return noticeRead;
    }

    public void setNoticeRead(Integer noticeRead) {
        this.noticeRead = noticeRead;
    }
}