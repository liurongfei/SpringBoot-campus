package cn.edu.jxnu.rj.lrf.service.impl;


import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCode;
import cn.edu.jxnu.rj.lrf.dao.UserMapper;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService, ErrorCode {

    @Autowired
    UserMapper userDao;

    @Override
    @Transactional
    public void register(User user) {
        if(user==null){
            throw new BusinessException(PARAMETER_ERROR,"参数不能为空");
        }

        try{
            userDao.insertSelective(user);
        }catch(DuplicateKeyException e){
            throw new BusinessException(PARAMETER_ERROR,"该手机号已注册!");
        }
    }

    @Override
    @Transactional
    public User login(String userPhone, String userPassword) {
        if(StringUtils.isEmpty(userPhone)||StringUtils.isEmpty(userPassword)){
            throw new BusinessException(PARAMETER_ERROR,"参数不合法");
        }

        User user = userDao.selectForLogin(userPhone);
        //判断
        if (user == null || !StringUtils.equals(userPassword,user.getUserPassword())) {//是否存在账号
            throw new BusinessException(USER_LOGIN_FAILURE,"账号或密码错误！");
        }
        return user;
    }

    @Override
    public void logout(int userId) {
        userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public User findById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findByName(String name, String lastName) {
        return null;
    }


    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateImage(int userId, String path) {
        User user = new User();
        user.setUserId(userId);
        user.setUserImage(path);
        userDao.updateByPrimaryKeySelective(user);
    }
}
