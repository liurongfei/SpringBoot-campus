package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.dao.MessageMapper;
import cn.edu.jxnu.rj.lrf.entity.Message;
import cn.edu.jxnu.rj.lrf.service.MessageService;
import cn.edu.jxnu.rj.lrf.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname MessageController
 * @Description TODO 聊天消息
 * @Date 2021/5/19 9:00
 * @Created by 傅联强
 */

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    /**
     * @Description //TODO 发送消息
     * @Param [message]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/messagePost")
    public ResponseModel message(Message message){
        if(message == null){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        messageService.post(message);
        return new ResponseModel();
    }

    /**
     * @Description //TODO 删除某条消息
     * @Param [message]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/deleteMessage")
    public ResponseModel deleteMessage(int messageId){
        if(messageId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        messageService.deleteMessage(messageId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO 查看两个的聊天消息
     * @Param [message]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/getMessage")
    public  ResponseModel getMessage(int sendUserId,int receiveUserId){
        if(sendUserId<=0||receiveUserId<=0){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数异常");
        }
        List<Message> list = messageService.getMessage(sendUserId,receiveUserId);
        return new ResponseModel(list);
    }
}
