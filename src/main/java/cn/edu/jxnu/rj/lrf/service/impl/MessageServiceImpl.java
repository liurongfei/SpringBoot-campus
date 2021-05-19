package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.MessageMapper;
import cn.edu.jxnu.rj.lrf.entity.Message;
import cn.edu.jxnu.rj.lrf.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname MessageServiceImpl
 * @Description TODO 聊天消息
 * @Date 2021/5/19 8:59
 * @Created by 傅联强
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    /**
     * @Description //TODO 发送聊天消息
     * @Param [message]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Message>
     **/
    @Override
    public List<Message> post(Message message) {
       messageMapper.insertSelective(message);
       return null;
    }

    /**
     * @Description //TODO 删除某条聊天记录
     * @Param [messageId]
     * @return void
     **/
    @Override
    public void deleteMessage(int messageId) {
        messageMapper.deleteByPrimaryKey(messageId);
    }

    /**
     * @Description //TODO 查看聊天消息
     * @Param [sendUserId, receiveUserId]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Message>
     **/
    @Override
    public List<Message> getMessage(int sendUserId, int receiveUserId) {
        return messageMapper.getMessage(sendUserId,receiveUserId);
    }
}
