package com.chaOreum.dao.contents.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.contents.ContentsDao;

@Repository
public class MybatisContentsDao implements ContentsDao {
	
	ContentsDao contentsDao;
	
	public MybatisContentsDao(SqlSession session) {
		contentsDao = session.getMapper(ContentsDao.class);
	}

	
	
}