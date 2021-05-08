package cn.edu.jxnu.rj.lrf.dto;

import cn.edu.jxnu.rj.lrf.entity.User;

/**
 * @author liu rong fei
 * @title: UserDto
 * @description:
 * @date: 2021/4/18 11:00
 */
public class UserViewDto extends User {
    /**
     *
     * user_id
     */
    private Integer userId;

    /**
     * 用户名
     * user_name
     */
    private String userName;

    /**
     * 学校
     * user_school
     */
    private String userSchool;

    /**
     * 头像路径
     * user_image
     */
    private String userImage;
}
