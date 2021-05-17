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

    }

    @Override
    public void CommentLike(int commentId, int userId) {
        String key = "comment:"+commentId+":like";
        redisTemplate.opsForSet().add(key,userId);
    }
}
