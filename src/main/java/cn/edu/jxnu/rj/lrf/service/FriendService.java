package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.User;

import java.util.List;
import java.util.Set;


public interface FriendService {
    /**
     * @Description //TODO 通过userId查询用户的好友
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    Set<String> getFriends(String userId);




    /**
     * @Description //TODO  通过用户id查询该用户关注
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    Set<String> getFollows(String userId);



    /**
     * @Description //TODO  通过用户id查看该用户的粉丝数
     * @Param [userId]
     * @return java.util.Set<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    Set<String> getFollowers(String userId);



    /**
     * @Description //TODO 用户关注好友，先查询用户信息，将用户信息存入到set中
     * @Param [userId, friendId]
     * @return void
     **/
    void follow(String userId,String followId);



    /**
     * @Description //TODO  用户取消关注
     * @Param [userId, followId]
     * @return void
     **/
    void cancelFollow(String userId,String followId);



    /**
     * @Description //TODO    移除关注
     * @Param [userId, followerId]
     * @return void
     **/
    void removeFollowers(String userId,String followerId);




    /**
     * @Description //TODO  判断两个用户是否为好友关系
     * @Param [userId, friendId]
     * @return boolean
     **/
    boolean isFriend(String userId,String friendId);




    /**
     * @Description //TODO    判断是否关注该用户
     * @Param [userId, friendId]
     * @return boolean
     **/
    boolean isFollow(String userId,String friendId);
}
