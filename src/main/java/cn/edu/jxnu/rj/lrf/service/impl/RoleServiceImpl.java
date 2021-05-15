package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.entity.Role;
import cn.edu.jxnu.rj.lrf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RoleServiceImpl
 * @Description TODO 角色操作业务实现类
 * @Date 2021/5/15 15:32
 * @Created by 刘荣飞
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getRolesByUserId(int userId) {
        System.out.println("getRolesByUserId");
        return null;
    }
}
