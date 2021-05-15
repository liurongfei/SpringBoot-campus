package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.Role;

import java.util.List;

/**
 * @InterfaceName RoleService
 * @Description TODO 角色操作业务
 * @Date 2021/5/15 15:25
 * @Created by 刘荣飞
 */
public interface RoleService {
    /**
     * @Description //TODO 根据用户id获取该用户的所有角色
     * @Param [userId] 用户id
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.Role>
     **/
    List<Role> getRolesByUserId(int userId);


}
