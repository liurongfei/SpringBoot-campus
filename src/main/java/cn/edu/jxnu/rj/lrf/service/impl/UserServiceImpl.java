package cn.edu.jxnu.rj.lrf.service.impl;


import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.dao.UserMapper;
import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.UserService;
import cn.edu.jxnu.rj.lrf.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserMapper userDao;

    @Override
    @Transactional
    public void register(User user) {
        if(user==null){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数不能为空");
        }
        //生成随机盐
        String salt = Util.getSalt(8);
        user.setSalt(salt);
        logger.info("user:"+user);
        logger.info("salt:"+salt);
        try{
            Md5Hash md5Hash = new Md5Hash(user.getUserPassword(),salt,1024);
            user.setUserPassword(md5Hash.toHex());
            userDao.insertSelective(user);
        }catch(DuplicateKeyException e){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"该手机号已注册!");
        }
    }

    @Override
    @Transactional
    public User login(String userPhone, String userPassword) {
        if(StringUtils.isEmpty(userPhone)||StringUtils.isEmpty(userPassword)){
            throw new BusinessException(ErrorCodeEnum.PARAMETER_ERROR.getCode(),"参数不合法");
        }

        User user = userDao.selectForLogin(userPhone);
        //判断
        if (user == null || !StringUtils.equals(userPassword,user.getUserPassword())) {//是否存在账号
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_FAILURE.getCode(),"账号或密码错误！");
        }
        return user;
    }

    @Override
    public User findByUserPhone(String userPhone) {
        User user = userDao.selectForLogin(userPhone);
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

    @Override
    public List<User> getALl() {
        return userDao.selectAll();
    }
}
