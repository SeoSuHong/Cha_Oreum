package com.chaOreum.dao.contents.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.SubCategoryView;

@Repository
public class MybatisContentsDao implements ContentsDao {
	
	ContentsDao postDao;
	
	public MybatisContentsDao(SqlSession session) {
		postDao = session.getMapper(ContentsDao.class);
	}

	@Override
	public List<String> getMainCategories() {
		
		List<String> mainCategories = postDao.getMainCategories();
		
		return mainCategories;
	}
	
	@Override
	public List<SubCategoryView> getSubCategories() {
		
		List<SubCategoryView> subCategories = postDao.getSubCategories();
		
		return subCategories;
	}
}