package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.entity.Notice;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.FriendService;
import cn.edu.jxnu.rj.lrf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    /**
     * @Description //TODO  查看好友关系
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    @Override
    public Set<User> getFriends(String userId) {
        String key ="user:"+userId+":follow";
        Set<User> member =redisTemplate.opsForSet().members(key);
        return member;
    }
    /**
     * @Description //TODO  查看关注
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    @Override
    public Set<User> getFollows(String userId) {
        String key = "user:"+userId+":follow";
        Set<User> members = redisTemplate.opsForSet().members(key);
        return members;
    }
    /**
     * @Description //TODO  查看粉丝
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    @Override
    public Set<User> getFollowers(String userId) {
        String key = "user:"+userId+":follow";
        Set<User> members = redisTemplate.opsForSet().members(key);
        return members;
    }

    /**
     * @Description //TODO  存入关注信息
     * @Param [userId, friendId]
     * @return void
     **/

    @Override
    public void follow(String userId, String friendId) {
        //先查询需要关注的用户信息
        User user = userService.findById(Integer.parseInt(friendId));
        User user2 = userService.findById(Integer.parseInt(userId));

        String key = "user:"+userId+":follow";
        String key2 = "user"+friendId+":follower";
        //将被关注用户信息存入到当前用户的关注集合中
        redisTemplate.opsForSet().add(key,user);
        //将关注者用户信息，存入到被关注者的粉丝集合中
        redisTemplate.opsForSet().add(key2,user2);
    }

    /**
     * @Description //TODO   用户取消关注
     * @Param [userId, followId]
     * @return void
     **/
    @Override
    public void cancelFollow(String userId, String followId) {
        //先查询需要取消关注的用户信息
        User user = userService.findById(Integer.parseInt(followId));
        User user2 = userService.findById(Integer.parseInt(userId));


    }

    /**
     * @Description //TODO  被关注者移除关注
     * @Param [userId, followerId]
     * @return void
     **/
    @Override
    public void removeFollowers(String userId, String followerId) {

    }

    /**
     * @Description //TODO  判断两个用户是否，是好友关系
     * @Param [userId, friendId]
     * @return boolean
     **/
    @Override
    public boolean isFriend(String userId, String friendId) {
        return false;
    }

    /**
     * @Description //TODO  判断两个用户是否,是关注状态
     * @Param [userId, friendId]
     * @return boolean
     **/
    @Override
    public boolean isFollow(String userId, String friendId) {

        return false;
    }
}
