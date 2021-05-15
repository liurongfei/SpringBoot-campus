package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.Moments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MomentsMapper {
    int deleteByPrimaryKey(Integer momentId);

    int insert(Moments record);

    int insertSelective(Moments record);

    Moments selectByPrimaryKey(Integer momentId);

    /**
     * @Description //TODO 根据用户id查询
     * @Param [userId]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Moments>
     **/
    List<Moments> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Moments record);

    int updateByPrimaryKey(Moments record);
}