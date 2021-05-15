package cn.edu.jxnu.rj.lrf.dto;

import lombok.Data;

/**
 * @Classname FriendDto
 * @Description TODO 好友信息
 * @Date 2021/5/14 11:10
 * @Created by 刘荣飞
 */
@Data
public class FriendDto {
    private Integer userId;
    private String userName;
    private String userSchool;
    private String userImage;
}
