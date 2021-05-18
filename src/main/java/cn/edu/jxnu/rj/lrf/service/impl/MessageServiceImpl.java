package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Classname MessageServiceImpl
 * @Description TODO 聊天消息
 * @Date 2021/5/18 10:41
 * @Created by 傅联强
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void sendmessage(String messageContent, int sendUserId, int receiveUserId) {
        String key = "messageCintent:"+messageContent;
        redisTemplate.opsForSet().add(key,sendUserId,receiveUserId);
    }

}
