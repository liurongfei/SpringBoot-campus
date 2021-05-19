package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Message {
    /**
     * 消息id
     * message_id
     */
    private Integer messageId;

    /**
     * 消息内容
     * message_content
     */
    private String messageContent;

    /**
     * 发送用户
     * send_userId
     */
    private Integer sendUserId;

    /**
     * 接收用户
     * receive_userId
     */
    private Integer receiveUserId;

    /**
     * 发送时间
     * gmt_create
     */
    private Date gmtCreate;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}