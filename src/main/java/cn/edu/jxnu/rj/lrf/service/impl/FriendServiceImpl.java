//package cn.edu.jxnu.rj.lrf.service.impl;
//
//import cn.edu.jxnu.rj.lrf.cache.FriendDao;
//import cn.edu.jxnu.rj.lrf.dao.NoticeDao;
//import cn.edu.jxnu.rj.lrf.dao.UserDao;
//import cn.edu.jxnu.rj.lrf.entity.Notice;
//import cn.edu.jxnu.rj.lrf.entity.SessionAndUser;
//import cn.edu.jxnu.rj.lrf.entity.User;
//import cn.edu.jxnu.rj.lrf.service.FriendService;
//import cn.edu.jxnu.rj.lrf.websocket.OnlineWebSocket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.ConcurrentMap;
//
//@Service
//public class FriendServiceImpl implements FriendService {
//    @Autowired
//    FriendDao friendDao;
//    @Autowired
//    UserDao userDao;
//    @Autowired
//    NoticeDao noticeDao;
//
//    @Override
//    public List<User> getFriends(String userId) {
//        Set<String> friends = friendDao.getFriends(userId);
//        List<User> users = new ArrayList<>();
//        if(friends.size()==0){
//            return null;
//        }else {
//            users = userDao.findUsers(friends);
//        }
//        return users;
//    }
//
//    @Override
//    public List<User> getFollows(String userId) {
//        Set<String> friends = friendDao.getFollows(userId);
//
//        List<User> users = new ArrayList<>();
//        if(friends.size()==0){
//            return null;
//        }else {
//            users = userDao.findUsers(friends);
//        }
//        return users;
//    }
//
//    @Override
//    public List<User> getFollowers(String userId) {
//        Set<String> friends = friendDao.getFollowers(userId);
//
//        List<User> users = new ArrayList<>();
//        if(friends.size()==0){
//            return null;
//        }else {
//            users = userDao.findUsers(friends);
//        }
//        return users;
//    }
//
//    @Override
//    public void follow(String userId, String friendId) {
//        friendDao.follow(userId,friendId);
//
//        //更新用户的关注数
//        userDao.updateFollows(Integer.parseInt(userId),1);
//        //更新被关注用户的粉丝数
//        userDao.updateFollowers(Integer.parseInt(friendId),1);
//
//        /**
//         * 通知被评论用户
//         */
//        //判断用户是否在线
//        SessionAndUser OnlineUser = null;
//        ConcurrentMap<Integer, OnlineWebSocket> online = OnlineWebSocket.online;
//        if(online.containsKey(friendId)){
//            online.get(friendId).getSession().getAsyncRemote().sendText("notice:follow");
//        }
//
//
//        //插入消息记录
//        noticeDao.insert(new Notice(Integer.parseInt(userId),Integer.parseInt(friendId),2,"",0,0));
//
//    }
//
//    @Override
//    public void cancelFollow(String userId, String followId) {
//        friendDao.cancelFollow(userId, followId);
//
//        //更新用户的关注数
//        userDao.updateFollows(Integer.parseInt(userId),-1);
//
//        //更新被关注用户的粉丝数
//        userDao.updateFollowers(Integer.parseInt(userId),-1);
//
//    }
//
//    @Override
//    public void removeFollowers(String userId, String followerId) {
//        friendDao.removeFollowers(userId, followerId);
//
//        //更新用户的粉丝数
//        userDao.updateFollowers(Integer.parseInt(userId),-1);
//
//        //更新被移除关注用户的关注数
//        userDao.updateFollows(Integer.parseInt(followerId),-1);
//    }
//
//    @Override
//    public boolean isFriend(String userId, String friendId) {
//        return friendDao.isFriend(userId, friendId);
//    }
//
//    @Override
//    public boolean isFollow(String userId, String friendId) {
//        return friendDao.isFollow(userId, friendId);
//    }
//}
