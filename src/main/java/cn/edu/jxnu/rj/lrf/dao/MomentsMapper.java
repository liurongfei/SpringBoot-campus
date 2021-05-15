package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Moments;
import org.springframework.stereotype.Repository;

@Repository
public interface MomentsMapper {
    int deleteByPrimaryKey(Integer momentId);

    int insert(Moments record);

    int insertSelective(Moments record);

    Moments selectByPrimaryKey(Integer momentId);

    int updateByPrimaryKeySelective(Moments record);

    int updateByPrimaryKey(Moments record);
}