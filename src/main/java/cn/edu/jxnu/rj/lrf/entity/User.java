package cn.edu.jxnu.rj.lrf.entity;

import java.util.Date;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class User {
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
     * 手机号
     * user_phone
     */
    private String userPhone;

    /**
     * 性别：0男1女
     * user_gender
     */
    private Integer userGender;

    /**
     * 生日
     * user_birthday
     */
    private Date userBirthday;

    /**
     * 年龄
     * user_age
     */
    private Integer userAge;

    /**
     * 密码
     * user_password
     */
    private String userPassword;

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
     * 匹配状态： 0未匹配1正在匹配2匹配成功
     * user_match_status
     */
    private Integer userMatchStatus;

    /**
     * 个人签名
     * user_signature
     */
    private String userSignature;

    /**
     * 真实姓名
     * user_realname
     */
    private String userRealname;

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

    /**
     * 创建时间
     * gmt_create
     */
    private Date gmtCreate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince == null ? null : userProvince.trim();
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    public Integer getUserEmotionStatus() {
        return userEmotionStatus;
    }

    public void setUserEmotionStatus(Integer userEmotionStatus) {
        this.userEmotionStatus = userEmotionStatus;
    }

    public Integer getUserMatchStatus() {
        return userMatchStatus;
    }

    public void setUserMatchStatus(Integer userMatchStatus) {
        this.userMatchStatus = userMatchStatus;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept == null ? null : userDept.trim();
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor == null ? null : userMajor.trim();
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade == null ? null : userGrade.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}