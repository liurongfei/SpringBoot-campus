//package cn.edu.jxnu.rj.lrf.service.impl;
//
//import cn.edu.jxnu.rj.lrf.dao.*;
//import cn.edu.jxnu.rj.lrf.entity.Comment;
//import cn.edu.jxnu.rj.lrf.entity.Notice;
//import cn.edu.jxnu.rj.lrf.entity.SessionAndUser;
//import cn.edu.jxnu.rj.lrf.entity.User;
//import cn.edu.jxnu.rj.lrf.service.CommentService;
//import cn.edu.jxnu.rj.lrf.websocket.OnlineWebSocket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.concurrent.ConcurrentMap;
//
//@Service("commentService")
//public class CommentServiceImpl implements CommentService {
//    @Autowired
//    CommentMapper commentDao;
//
//    @Autowired
//    UserMapper userDao;
//
//    @Autowired
//    ReplyMapper replyDao;
//
//    @Autowired
//    DynamicMapper dynamicDao;
//
//    @Autowired
//    GiveLikeMapper giveLikeDao;
//
//    @Autowired
//    NoticeMapper noticeDao;
//
//    @Override
//    @Transactional
//    public void post(Comment comment) {
//        //被通知用户id
//        int noticedUserId = 0;
//
//        User user = userDao.findNameAndImage(comment.getUserId());
//
//        if(user!=null){
//            comment.setUserName(user.getUserName());
//            comment.setUserImage(user.getUserImage());
//        }
//        commentDao.post(comment);
//
//        //更新作品评论数字段
//        int workType = comment.getWorkType();
//        int workId = comment.getWorkId();
//        if(workType==0){
//            dynamicDao.updateCommentNum(workId,1);
//            noticedUserId = dynamicDao.getUserId(workId);
//        }
//
//        /**
//         * 通知被评论用户
//         */
//        //判断用户是否在线
//        SessionAndUser OnlineUser = null;
//        ConcurrentMap<Integer, OnlineWebSocket> online = OnlineWebSocket.online;
//        if(online.containsKey(noticedUserId)){
//            online.get(noticedUserId).getSession().getAsyncRemote().sendText("notice:comment");
//        }
//
//        //插入消息记录
//        noticeDao.insert(new Notice(comment.getUserId(),noticedUserId,3,comment.getCommentContent(),comment.getCommentId(),1));
//
//    }
//
//    @Override
//    @Transactional
//    public void delete(int commentId) {
//        //删除评论，回复级联删除
//        commentDao.delete(commentId);
//        //删除该评论下的点赞
//        giveLikeDao.deleteAllByWork(3,commentId);
//
//        //更新作品的评论数字段
//        Comment work = commentDao.getWork(commentId);
//        int workType = work.getWorkType();
//        int workId = work.getWorkId();
//
//        if(workType==0){
//            dynamicDao.updateCommentNum(workId,1);
//        }
//
//    }
//
//    @Override
//    public List<Comment> getAllByWorkId(int workType, int WorkId) {
//        return commentDao.findByWorkId(workType, WorkId);//过去某作品下的所有评论
//    }
//}
