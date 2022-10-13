package com.chaOreum.dao.contents.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.Post;

@Repository
public class MybatisContentsDao implements ContentsDao {
	
	ContentsDao mapper;
	
	public MybatisContentsDao(SqlSession session) {
		mapper = session.getMapper(ContentsDao.class);
	}

	@Override
	public List<Post> getList(int category_no, String nickname, String title, String sort, int offset, int size) {
		return mapper.getList(category_no, nickname, title, sort, offset, size);
	}
}