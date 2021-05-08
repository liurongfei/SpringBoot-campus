package cn.edu.jxnu.rj.lrf.dto;

import cn.edu.jxnu.rj.lrf.entity.User;

/**
 * @author liu rong fei
 * @title: UserInfoDto
 * @description:
 * @date: 2021/4/18 11:06
 */
public class UserInfoDto extends User {
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
     * 性别：0男1女
     * user_gender
     */
    private Integer userGender;

    /**
     * 年龄
     * user_age
     */
    private Integer userAge;

    /**
     * 省份
     * user_province
     */
    private String userProvince;

    /**
     * 城市
     * user_city
     */
    private String userCity;

    /**
     * 感情状态： 0单身1恋爱中2保密
     * user_emotion_status
     */
    private Integer userEmotionStatus;


    /**
     * 个人签名
     * user_signature
     */
    private String userSignature;

    /**
     * 学校
     * user_school
     */
    private String userSchool;

    /**
     * 学院
     * user_dept
     */
    private String userDept;

    /**
     * 专业
     * user_major
     */
    private String userMajor;

    /**
     * 年级
     * user_grade
     */
    private String userGrade;

    /**
     * 头像路径
     * user_image
     */
    private String userImage;

}
