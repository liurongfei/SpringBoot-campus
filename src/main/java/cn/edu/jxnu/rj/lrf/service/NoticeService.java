package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.dto.NoticeNumDto;
import cn.edu.jxnu.rj.lrf.entity.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 获取用户通知数量
     * @param userId
     * @return
     */
    public List<NoticeNumDto> getNoticeNum(int userId);

    public List<Notice> getNotice(int userId, String noticeType);

    /**
     * 获取
     */

    /**
     * 标记为已读
     * @param userId
     * @param noticeType
     */
    public void setRead(int userId,int noticeType);
}
