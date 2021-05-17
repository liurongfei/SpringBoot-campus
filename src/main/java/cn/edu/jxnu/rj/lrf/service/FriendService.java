package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.User;

import java.util.List;
import java.util.Set;


public interface FriendService {

    Set<User> getFriends(String userId);//查看某用户的好友
    Set<User> getFollows(String userId);//查询某用户的关注
    Set<User> getFollowers(String userId);//查看某用户的粉丝

    /**
     * @Description //TODO 用户关注好友，先查询用户信息，将用户信息存入到set中
     * @Param [userId, friendId]
     * @return void
     **/
    void follow(String userId,String friendId);
    void cancelFollow(String userId,String followId);//用户取消关注
    void removeFollowers(String userId,String followerId);//移除关注
    boolean isFriend(String userId,String friendId);//判断两个用户是否为好友关系
    boolean isFollow(String userId,String friendId);//判断是否关注该用户
}
