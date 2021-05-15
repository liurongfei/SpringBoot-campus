package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}