package com.chaOreum.dao.notice.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.notice.NoticeDao;
import com.chaOreum.entity.NoticeView;

@Repository
public class MybatisNoticeDao implements NoticeDao {

	private NoticeDao mapper;
	
	@Autowired
	public MybatisNoticeDao(SqlSession session) {
		mapper = session.getMapper(NoticeDao.class);
	}
	
	@Override
	public List<NoticeView> getNoticeViewList() {
		return mapper.getNoticeViewList();
	}
	
	@Override
	public NoticeView getView(int no) {
		return mapper.getView(no);
	}
}
