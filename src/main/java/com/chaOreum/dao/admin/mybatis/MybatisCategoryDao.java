package com.chaOreum.dao.admin.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.admin.CategoryDao;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

@Repository
public class MybatisCategoryDao implements CategoryDao {
	
	private CategoryDao mapper;
	
	@Autowired
	public MybatisCategoryDao(SqlSession session) {
		mapper = session.getMapper(CategoryDao.class);
	}

	@Override
	public List<MainCategory> getMainList() {
		return mapper.getMainList();
	}
	
	@Override
	public List<SubCategory> getSubList() {
		return mapper.getSubList();
	}
	
	@Override
	public int regMainCategory(String name) {
		return mapper.regMainCategory(name);
	}
	
	@Override
	public int editMainCategory(int no, String name) {
		return mapper.editMainCategory(no, name);
	}
	
	@Override
	public int deleteMainCategory(int no) {
		return mapper.deleteMainCategory(no);
	}
	
	@Override
	public int regSubCategory(int mainCategory_no, String name) {
		return mapper.regSubCategory(mainCategory_no, name);
	}
	
	@Override
	public int editSubCategory(int no, int mainCategory_no, String name) {
		return mapper.editSubCategory(no, mainCategory_no, name);
	}
	
	@Override
	public int deleteSubCategory(int no) {
		return mapper.deleteSubCategory(no);
	}
}
