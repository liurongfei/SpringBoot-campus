//package cn.edu.jxnu.rj.lrf.service.impl;
//
//
//import cn.edu.jxnu.rj.lrf.dao.*;
//import cn.edu.jxnu.rj.lrf.entity.Givelike;
//import cn.edu.jxnu.rj.lrf.entity.Notice;
//import cn.edu.jxnu.rj.lrf.entity.SessionAndUser;
//import cn.edu.jxnu.rj.lrf.service.GiveLikeService;
//import cn.edu.jxnu.rj.lrf.websocket.OnlineWebSocket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.concurrent.ConcurrentMap;
//
//@Service
//public class GiveLikeServiceImpl implements GiveLikeService {
//    @Autowired
//    GiveLikeDao giveLikeDao;
//
//    @Autowired
//    CommentDao commentDao;
//
//    @Autowired
//    DynamicDao dynamicDao;
//
//    @Autowired
//    ReplyDao replyDao;
//
//    @Autowired
//    ConfessionDao confessionDao;
//
//    @Autowired
//    PuzzleDao puzzleDao;
//
//    @Autowired
//    NoticeDao noticeDao;
//
//    @Override
//    @Transactional
//    public void like(Givelike like) {
//        int i = giveLikeDao.insert(like);
//
//        int workType = like.getWorkType();
//        int workId = like.getWorkId();
//        int noticedUserId = 0;
//
//        //更新作品点赞字段，并获取被通知用户id
//        switch (workType){
//            case 0:{
//                dynamicDao.updateLikeNum(workId);
//                noticedUserId = dynamicDao.getUserId(workId);
//                break;
//            }
//            case 1:{
//                confessionDao.updateLikesNum(workId);
//                noticedUserId = confessionDao.getUserId(workId);
//                break;
//            }
//            case 2:{
//                puzzleDao.updateLikesNum(workId);
//                noticedUserId = puzzleDao.getUserId(workId);
//                break;
//            }
//            case 3:{
//                commentDao.updateLikeNum(workId);
//                noticedUserId = commentDao.getUserId(workId);
//                break;
//            }
//            case 4:{
//                replyDao.updateLikesNum(workId);
//                noticedUserId = replyDao.getUserId(workId);
//                break;
//            }
//        }
//
//        /**
//         * 通知被点赞用户
//         */
//
//        if(i==1){//第一次点赞，没有取消
//
//            //判断用户是否在线
//            SessionAndUser OnlineUser = null;
//            ConcurrentMap<Integer, OnlineWebSocket> online = OnlineWebSocket.online;
//            if(online.containsKey(noticedUserId)){
//                online.get(noticedUserId).getSession().getAsyncRemote().sendText("notice:like");
//            }
//
//            //插入消息记录
//            noticeDao.insert(new Notice(like.getUserId(),noticedUserId,1,"",workId,workType));
//
//        }
//
//    }
//}
