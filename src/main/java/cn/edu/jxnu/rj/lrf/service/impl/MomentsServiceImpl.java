package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.CommentMapper;
import cn.edu.jxnu.rj.lrf.dao.ImageMapper;
import cn.edu.jxnu.rj.lrf.dao.MomentsMapper;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import cn.edu.jxnu.rj.lrf.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class MomentsServiceImpl implements MomentsService {

    @Autowired
    MomentsMapper momentsMapper;

    @Override
    public void post(Moments dynamic, List<String> imagePath) {

    }


    @Override
    public List<Moments> getAllByUserId(int userId) {
        return momentsMapper.selectByUserId(userId);
    }

    @Override
    public void deleteByMomentId(int momentId) {
        momentsMapper.deleteByPrimaryKey(momentId);
    }

    @Override
    public Moments findById(int momentId) {
        return momentsMapper.selectByPrimaryKey(momentId);
    }
}
