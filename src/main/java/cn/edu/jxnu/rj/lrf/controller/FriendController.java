package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.dto.FriendDto;
import cn.edu.jxnu.rj.lrf.service.FriendService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Classname FriendController
 * @Description TODO 好友操作
 * @Date 2021/5/14 11:02
 * @Created by 刘荣飞
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    FriendService friendService;


    /*
     * @Description //TODO  查看好友，通过个人的userId
     * @Param [userId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/getFriends")
    public ResponseModel getFriends(String userId){
        friendService.getFriends(userId);
        return new ResponseModel();
    }



    /**
     * @Description //TODO  查看关注者，userId是被关注的人.通过userId查看关注者
     * @Param [userId, friendId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/getFollow")
    public ResponseModel getFollow(String userId){
        friendService.getFollows(userId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO 通过userId查看该用户的粉丝
     * @Param [userId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/getFans")
    public ResponseModel getFans(String userId){
        friendService.getFollowers(userId);
        return new ResponseModel();
    }


    /**
     * @Description //TODO  存入数据
     * @Param [userId, followId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/setFollow/{userId}")
    //userId是被关注者
    public ResponseModel setFollow(@PathVariable("userId") String userId,String followId ){
        friendService.follow(userId,followId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO  取消关注
     * @Param [userId, followId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/cancelFollow/{userId}")
    public ResponseModel cancelFollow(@PathVariable("userId") String userId, String followId){
        friendService.cancelFollow(userId,followId);
        return new ResponseModel();
    }


    /**
     * @Description //TODO  移除关注
     * @Param [userId, followerId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/removeFollowers/{followerId}")
    public ResponseModel removeFollowers(String userId,@PathVariable("followerId") String followerId){
        friendService.removeFollowers(userId,followerId);
        return new ResponseModel();
    }

    /**
     * @Description //TODO  判断两个用户是否还是好友
     * @Param [userId, followerId]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @RequestMapping("/isFriend")
    public ResponseModel isFriend(String userId,String followerId){
        friendService.isFriend(userId, followerId);
        return new ResponseModel();
    }

    @RequestMapping("/isFollow")
    public ResponseModel isFollow(String userId,String followerId){
        friendService.isFollow(userId, followerId);
        return new ResponseModel();
    }

}
