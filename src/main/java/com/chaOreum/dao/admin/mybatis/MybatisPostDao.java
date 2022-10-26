package com.chaOreum.dao.admin.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.admin.PostDao;
import com.chaOreum.entity.PostView;

@Repository
public class MybatisPostDao implements PostDao {

	private PostDao mapper;
	
	@Autowired
	public MybatisPostDao(SqlSession session) {
		mapper = session.getMapper(PostDao.class);
	}

	@Override
	public List<PostView> getViewList(String category, String title, String id, int page, int offset, int size) {
		return mapper.getViewList(category, title, id, page, offset, size);
	}
	
	@Override
	public int getEndPage(String category, String title, String id) {
		return mapper.getEndPage(category, title, id);
	}
	
	@Override
	public int delete(int no) {
		return mapper.delete(no);
	}
	
}
