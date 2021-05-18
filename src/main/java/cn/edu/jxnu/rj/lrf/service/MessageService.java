package cn.edu.jxnu.rj.lrf.service;

import java.util.Date;

/**
 * @Interfacename MessageService
 * @Description TODO 聊天消息
 * @Date 2021/5/18 10:44
 * @Created by 傅联强
 */
public interface MessageService {
    /**
     * @Description //TODO 发送消息
     * @Param [messageId, messageContent, sendUserId, receiveUserId]
     * @return void
     **/
    void sendmessage(String messageContent, int sendUserId, int receiveUserId);


}
