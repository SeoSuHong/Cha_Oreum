package com.chaOreum.dao.admin.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.admin.NoticeDao;
import com.chaOreum.entity.Notice;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
import com.chaOreum.entity.NoticeView;

@Repository
public class MybatisNoticeDao implements NoticeDao {

	private NoticeDao mapper;
	
	@Autowired
	public MybatisNoticeDao(SqlSession session) {
		mapper = session.getMapper(NoticeDao.class);
	}
	
	@Override
	public List<NoticeView> getViewList() {
		return mapper.getViewList();
	}
	
	@Override
	public NoticeView getView(int no) {
		return mapper.getView(no);
	}
	
	@Override
	public int set(Notice notice) {
		return mapper.set(notice);
	}
	
	@Override
	public int edit(Notice notice) {
		return mapper.edit(notice);
	}
	
	@Override
	public List<NoticeComment> getComments(int no) {
		return mapper.getComments(no);
	}
	
	@Override
	public int setComment(NoticeComment comment) {
		return mapper.setComment(comment);
	}
	
	@Override
	public int commentDelete(int no) {
		return mapper.commentDelete(no);
	}

	@Override
	public List<NoticeReply> getReplies(int no) {
		return mapper.getReplies(no);
	}
	
	@Override
	public int setReply(NoticeReply reply) {
		return mapper.setReply(reply);
	}
	
	@Override
	public int replyDelete(int no) {
		return mapper.replyDelete(no);
	}
	
	@Override
	public int delete(int no) {
		return mapper.delete(no);
	}
}
