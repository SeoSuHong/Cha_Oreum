package com.chaOreum.dao.contents.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.PostView;

@Repository
public class MybatisContentsDao implements ContentsDao {
	
	ContentsDao mapper;
	
	@Autowired
	public MybatisContentsDao(SqlSession session) {
		mapper = session.getMapper(ContentsDao.class);
	}

	@Override
	public List<PostView> getViewList(int category_no, String nickname, String title, String sort, int offset, int size) {
		return mapper.getViewList(category_no, nickname, title, sort, offset, size);
	}
	
	@Override
	public int getEndPage(int category_no, String nickname, String title) {
		return mapper.getEndPage(category_no, nickname, title);
	}
}