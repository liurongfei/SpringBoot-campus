package cn.edu.jxnu.rj.lrf.service.impl;


import cn.edu.jxnu.rj.lrf.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void MomentLike(int momentId, int userId) {
        String key = "moment:"+momentId+":like";
        redisTemplate.opsForSet().add(key,userId);

    }

    @Override
    public void cancelMomentLike(int momentId, int userId) {
        String key = "moment:"+momentId+":like";
        redisTemplate.opsForSet().remove(key,userId);
    }

    @Override
    public boolean isMomentLike(int momentId, int userId) {
        String key = "moment:"+momentId+":like";
        return redisTemplate.opsForSet().isMember(key,userId);
    }

    @Override
    public long getMomentLikeAmount(int momentId) {
        String key = "moment:"+momentId+":like";
        long size = redisTemplate.opsForSet().size(key);
        return size;
    }

    @Override
    public void CommentLike(int commentId, int userId) {
        String key = "comment:"+commentId+":like";
        redisTemplate.opsForSet().add(key,userId);
    }

    @Override
    public void cancelCommentLike(int commentId, int userId) {
        String key = "comment:"+commentId+":like";
        redisTemplate.opsForSet().remove(key,userId);
    }

    @Override
    public boolean isCommentLike(int commentId, int userId) {
        String key = "comment:" + commentId + ":like";
        return redisTemplate.opsForSet().isMember(key, userId);
    }

    @Override
    public long getCommentLikeAmount(int commentId) {
        String key = "comment:" + commentId + ":like";
        long size = redisTemplate.opsForSet().size(key);
        return size;
    }
}
