//package cn.edu.jxnu.rj.lrf.service.impl;
//
//
//import cn.edu.jxnu.rj.lrf.dao.*;
//import cn.edu.jxnu.rj.lrf.entity.Reply;
//import cn.edu.jxnu.rj.lrf.service.ReplyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class ReplyServiceImpl implements ReplyService {
//    @Autowired
//    ReplyMapper replyDao;
//
//    @Autowired
//    UserMapper userDao;
//
//    @Autowired
//    CommentMapper commentDao;
//
//    @Autowired
//    GiveLikeMapper giveLikeDao;
//
//    @Autowired
//    NoticeMapper noticeDao;
//
//    @Override
//    @Transactional
//    public void post(Reply reply) {
////        User user1 = userDao.findNameAndImage(reply.getUserId1());
////        User user2 = userDao.findNameAndImage(reply.getUserId2());
////        if(user1!=null){
////            reply.setUserName1(user1.getUserName());
////            reply.setUserImage1(user1.getUserImage());
////        }
////        if(user2!=null){
////            reply.setUserName2(user2.getUserName());
////        }
////        //插入回复
////        replyDao.insert(reply);
////
////        //更新评论回复数字段
////        commentDao.updateReplyNum(reply.getCommentId(),1);
////
////
////        /**
////         * 通知被评论用户
////         */
////        //判断用户是否在线
////        SessionAndUser OnlineUser = null;
////        ConcurrentMap<Integer, OnlineWebSocket> online = OnlineWebSocket.online;
////        if(online.containsKey(reply.getUserId2())){
////            online.get(reply.getUserId2()).getSession().getAsyncRemote().sendText("notice:reply");
////        }
////
////        //插入消息记录
////        noticeDao.insert(new Notice(reply.getUserId1(),reply.getUserId2(),4,reply.getReplyContent(),reply.getReplyId(),2));
//
//    }
//
//
//    @Override
//    @Transactional
//    public void deleteReply(int replyId) {
////        //删除回复
////        replyDao.delete(replyId);
////        //删除回复的所有点赞记录
////        giveLikeDao.deleteAllByWork(4,replyId);
////        int commentId = replyDao.getCommentId(replyId);
////        //更新评论的回复数
////        commentDao.updateReplyNum(commentId,-1);
//    }
//
////    @Override
//    public List<Reply> getAllInComment(int commentId) {
////        return replyDao.getAllByCommentId(commentId);
//        return null;
//    }
//}
