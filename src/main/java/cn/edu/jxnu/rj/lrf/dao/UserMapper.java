package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);//查看单个用户的个人信息

    User selectForLogin(String userPhone);//登录校验信息

    /**
     * @Description //TODO 获取所有用户信息
     * @Param []
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    List<User> selectAll();

    List<User> selectByName(@Param("name") String name, @Param("lastUserId") String lastUserId);//搜索用户,分页

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}