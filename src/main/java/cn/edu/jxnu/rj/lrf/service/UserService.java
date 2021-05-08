package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.User;

import java.util.List;

public interface UserService {
    User login(String userPhone, String userPassword);//登录
    void logout(int userId);//注销
    void register(User user);//注册
    User findById(int userId);//根据用户id获取用户信息
    List<User> findByName(String name,String lastName);//搜索用户
    void update(User user);//更新部分个人信息
    void updateImage(int userId,String path);//更新头像
}
