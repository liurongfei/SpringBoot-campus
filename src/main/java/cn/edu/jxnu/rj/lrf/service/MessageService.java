package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.Like;
import cn.edu.jxnu.rj.lrf.entity.Message;

import java.util.List;

/**
 * @Interfacename MessageService
 * @Description TODO 聊天消息
 * @Date 2021/5/19 9:01
 * @Created by 傅联强
 */
public interface MessageService {

/**
 * @Description //TODO 发送聊天消息
 * @Param [message]
 * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Message>
 **/
    List<Message> post(Message message);
}
