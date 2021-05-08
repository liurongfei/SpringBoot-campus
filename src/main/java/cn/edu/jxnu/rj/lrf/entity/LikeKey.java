package cn.edu.jxnu.rj.lrf.entity;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class LikeKey {
    /**
     * 点赞作品id
     * work_id
     */
    private Integer workId;

    /**
     * 作品类型： 0动态1表白2问题3评论4回复
     * work_type
     */
    private Integer workType;

    /**
     * 用户id
     * user_id
     */
    private Integer userId;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}