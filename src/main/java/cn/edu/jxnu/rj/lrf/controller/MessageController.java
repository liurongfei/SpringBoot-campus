package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MessageController
 * @Description TODO 聊天消息
 * @Date 2021/5/18 10:42
 * @Created by 傅联强
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/sendmessage")
    public ResponseModel sendmessage(String messageContent, int sendUserId, int receiveUserId){
    messageService.sendmessage(messageContent,sendUserId,receiveUserId);
    return new ResponseModel();
    }
}
