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
    public Set<String> getFriends(String userId) {
        String key ="user:"+userId+":follow";
        String key2="user:"+userId+":follower";
        Set<String> member= redisTemplate.opsForSet().intersect(key,key2);
        return member;
    }



    /**
     * @Description //TODO  查看关注
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    @Override
    public Set<String> getFollows(String userId) {
        String key = "user:"+userId+":follow";
        Set<String> members = redisTemplate.opsForSet().members(key);
        return members;
    }


    /**
     * @Description //TODO  查看粉丝
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    @Override
    public Set<String> getFollowers(String userId) {
        String key = "user:"+userId+":follower";
        Set<String> members = redisTemplate.opsForSet().members(key);
        return members;
    }


    /**
     * @Description //TODO  存入关注信息
     * @Param [userId, friendId]
     * @return void
     **/
    @Override
    public void follow(String userId, String followId) {  //userId是关注人的id，followId是被关注人的id
        String key = "user:"+userId+":follow";
        String key2 = "user"+followId+":follower";
        //将被关注用户信息存入到当前用户的关注集合中
        redisTemplate.opsForSet().add(key,followId);
        //将关注者用户信息，存入到被关注者的粉丝集合中
        redisTemplate.opsForSet().add(key2,userId);
    }


    /**
     * @Description //TODO   用户userId取消关注
     * @Param [userId, followId]
     * @return void
     **/
    @Override
    public void cancelFollow(String userId, String followId) {//是userId用户取消
        String key = "user:"+userId+":follow";
        String key2 = "user"+followId+":follower";
        //用户userId取消关注
        redisTemplate.opsForSet().remove(key,followId);
        //在follow删除userId信息
        redisTemplate.opsForSet().remove(key2,userId);
    }

    /**
     * @Description //TODO  被关注者移除关注
     * @Param [userId, followerId]
     * @return void
     **/
    @Override
    public void removeFollowers(String userId, String followerId) {  //是follwerId用户取消
            String key = "user:"+followerId+":follow";
            String key2 = "user"+userId+":follower";
            //被关注者followerId移除关注者userId
            redisTemplate.opsForSet().remove(key,userId);
            //在userId中删除followerId中删除信息
            redisTemplate.opsForSet().remove(key2,followerId);
    }

    /**
     * @Description //TODO  判断两个用户是否，是好友关系
     * @Param [userId, friendId]
     * @return boolean
     **/
    @Override
    public boolean isFriend(String userId, String friendId) {
        String key = "user:"+userId+":follow";
        String key2 = "user:"+friendId+":follow";
        boolean bool=redisTemplate.opsForSet().isMember(key,friendId);
        boolean bool1=redisTemplate.opsForSet().isMember(key2,userId);
        if(bool==true && bool1==true){
            return true;
        }
        return false;
    }

    /**
     * @Description //TODO  判断两个用户是否,是关注状态
     * @Param [userId, friendId]
     * @return boolean
     **/
    @Override
    public boolean isFollow(String userId, String followId) {
        String key = "user:"+userId+":follow";
        String key2 = "user:"+followId+":follow";
        boolean bool=redisTemplate.opsForSet().isMember(key,followId);
        boolean bool1=redisTemplate.opsForSet().isMember(key2,userId);
        if(bool==true && bool1==true){
            return true;
        }
        return false;
    }
}
