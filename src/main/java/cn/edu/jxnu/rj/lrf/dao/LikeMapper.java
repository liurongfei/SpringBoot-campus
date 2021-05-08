package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Like;
import cn.edu.jxnu.rj.lrf.entity.LikeKey;

public interface LikeMapper {
    int deleteByPrimaryKey(LikeKey key);

    int insert(Like record);

    int insertSelective(Like record);

    Like selectByPrimaryKey(LikeKey key);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}