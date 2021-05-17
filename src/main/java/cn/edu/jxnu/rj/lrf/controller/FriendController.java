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


    @RequestMapping("/get/{id}")
    @RequiresRoles("user")
    public ResponseModel get(@PathVariable("id") String id){
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("user")){
            System.out.println("当前角色是user");
            if(subject.isPermitted("user:find")){
                System.out.println("当前用户拥有权限：user:find");
            }
            if (subject.isPermitted("user:update")){
                System.out.println("当前用户拥有权限：user:update");
            }
        }
        String key = "user:"+id+":follower";
        Set<String> members = redisTemplate.opsForSet().members(key);

        return new ResponseModel(members);
    }

    @RequestMapping("/follow/{friendId}")
    public ResponseModel follow(@PathVariable("friendId") String friendId,Integer userId){
        friendService.follow(userId.toString(),friendId);
        return new ResponseModel();
    }
}
