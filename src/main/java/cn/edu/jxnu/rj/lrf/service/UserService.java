package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.User;

import java.util.List;

public interface UserService {
    /**
     * @Description //TODO 未使用shiro之前的用户登录方式
     * @Param [userPhone, userPassword] 用户手机号 用户密码
     * @return cn.edu.jxnu.rj.lrf.entity.User
     **/
    User login(String userPhone, String userPassword);//登录

    /**
     * @Description //TODO 根据用户手机号查找用户信息
     * @Param [userPhone]
     * @return java.lang.String
     **/
    User findByUserPhone(String userPhone);

    /**
     * @Description //TODO 注销用户，即将用户信息删除
     * @Param [userId]
     * @return void
     **/
    void logout(int userId);

    /**
     * @Description //TODO 注册用户
     * @Param [user]
     * @return void
     **/
    void register(User user);

    /**
     * @Description //TODO 根据用户id获取用户信息
     * @Param [userId]
     * @return cn.edu.jxnu.rj.lrf.entity.User
     **/
    User findById(int userId);


    /**
     * @Description //TODO 搜索用户
     * @Param [name, lastName]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    List<User> findByName(String name,String lastName);

    /**
     * @Description //TODO 更新部分个人信息
     * @Param [user] 需要更新的用户数据
     * @return void
     **/
    void update(User user);

    /**
     * @Description //TODO 更新头像
     * @Param [userId, path] 用户id 更新后的头像路径
     * @return void
     **/
    void updateImage(int userId,String path);

    /**
     * @Description //TODO 获取所有用户信息
     * @Param []
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.User>
     **/
    List<User> getALl();
}
