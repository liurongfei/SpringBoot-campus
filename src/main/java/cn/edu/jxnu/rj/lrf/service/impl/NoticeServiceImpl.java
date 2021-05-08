package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.NoticeMapper;
import cn.edu.jxnu.rj.lrf.dto.NoticeNumDto;
import cn.edu.jxnu.rj.lrf.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements cn.edu.jxnu.rj.lrf.service.NoticeService {
    @Autowired
    NoticeMapper noticeDao;

    @Override
    public List<NoticeNumDto> getNoticeNum(int userId) {
//        return noticeDao.getUnread(userId);
        return null;
    }

    @Override
    public List<Notice> getNotice(int userId, String noticeType) {
//        System.out.println("notice is "+noticeDao.select(userId, noticeType));
//        return noticeDao.select(userId, noticeType);
        return null;
    }

    @Override
    public void setRead(int userId, int noticeType) {
//        noticeDao.update(userId, noticeType);
//        System.out.println(userId+"<==============================>"+noticeType);
    }
}
