package com.chaOreum.dao.include.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.include.IncludeDao;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

@Repository
public class MybatisIncludeDao implements IncludeDao {
	
	private IncludeDao mapper;
	
	@Autowired
	public MybatisIncludeDao(SqlSession session) {
		mapper = session.getMapper(IncludeDao.class);
	}
	
	@Override
	public List<MainCategory> getMainCategories() {
		return getMainCategories("");
	}
	
	@Override
	public List<SubCategory> getSubCategories() {
		return getSubCategories("");
	}
	
	@Override
	public List<MainCategory> getMainCategories(String nickname) {
		return mapper.getMainCategories(nickname);
	}
	
	@Override
	public List<SubCategory> getSubCategories(String nickname) {
		return mapper.getSubCategories(nickname);
	}
}