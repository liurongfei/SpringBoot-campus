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
    NoticeMapper noticeMapper;

    @Override
    public List<NoticeNumDto> getNoticeNum(int userId) {
        return null;
    }

    @Override
    public List<Notice> getNotice(int userId, String noticeType) {

        return null;
    }

    @Override
    public void setRead(int userId, int noticeType) {

    }
}
