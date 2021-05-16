package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.Moments;

import java.util.List;

public interface MomentsService {
    void post(Moments dynamic, List<String> imagePath);//发表动态

    /**
     * @Description //TODO 通过用户id，获取该用户发布所有帖子
     * @Param [userId, localUserId]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Moments>
     **/
    List<Moments> getAllByUserId(int userId);//查看用户所有文章

//    List<Moments> getLatest(int start, int nums, int userId);//查询最近nums条动态
    /**
     * @Description //TODO 通过动态id删除动态
     * @Param [momentId]
     * @return void
     **/
    void deleteByMomentId(int momentId);//删除动态
    /**
     * @Description //TODO  通过momentId查看单条动态
     * @Param [momentId, userId]
     * @return cn.edu.jxnu.rj.lrf.entity.Moments
     **/
    Moments findById(int momentId);//查看单条动态

}
