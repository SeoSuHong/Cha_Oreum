package com.chaOreum.service.admin.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.admin.NoticeDao;
import com.chaOreum.entity.Notice;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
import com.chaOreum.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeView> getViewList() {
		return noticeDao.getViewList();
	}
	
	@Override
	public NoticeView getView(int no) {
		return noticeDao.getView(no);
	}
	
	@Override
	public int set(Notice notice) {
		return noticeDao.set(notice);
	}
	
	@Override
	public List<NoticeComment> getComments(int no) {
		return noticeDao.getComments(no);
	}
	
	@Override
	public List<NoticeReply> getReplies(int no) {
		return noticeDao.getReplies(no);
	}
	
	@Override
	public int delete(int no) {
		return noticeDao.delete(no);
	}
}
