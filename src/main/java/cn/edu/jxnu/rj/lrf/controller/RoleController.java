package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.service.RoleService;
import cn.edu.jxnu.rj.lrf.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RoleController
 * @Description TODO 角色操作请求
 * @Date 2021/5/15 15:33
 * @Created by 刘荣飞
 */
@RestController
//@ResponseBody + @Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/getAll")
    public ResponseModel getAll(int userId){
        roleService.getRolesByUserId(userId);

        return new ResponseModel();
    }
}
