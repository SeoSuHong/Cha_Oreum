package com.chaOreum.service.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.notice.NoticeDao;
import com.chaOreum.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeView> getNoticeViewList() {
		return noticeDao.getNoticeViewList();
	}
	
	@Override
	public NoticeView getView(int no) {
		return noticeDao.getView(no);
	}
}
