package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Noticetype;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticetypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Noticetype record);

    int insertSelective(Noticetype record);

    Noticetype selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Noticetype record);

    int updateByPrimaryKey(Noticetype record);
}