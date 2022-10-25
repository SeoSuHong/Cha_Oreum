package com.chaOreum.service.admin.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.admin.CategoryDao;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<MainCategory> getMainList() {
		return categoryDao.getMainList();
	}
	
	@Override
	public List<SubCategory> getSubList() {
		return categoryDao.getSubList();
	}
	
	@Override
	public int regMainCategory(String name) {
		return categoryDao.regMainCategory(name);
	}
	
	@Override
	public int editMainCategory(int no, String name) {
		return categoryDao.editMainCategory(no, name);
	}
	
	@Override
	public int deleteMainCategory(int no) {
		return categoryDao.deleteMainCategory(no);
	}
	
	@Override
	public int regSubCategory(int mainCategory_no, String name) {
		return categoryDao.regSubCategory(mainCategory_no, name);
	}
	
	@Override
	public int editSubCategory(int no, int mainCategory_no, String name) {
		return categoryDao.editSubCategory(no, mainCategory_no, name);
	}
	
	@Override
	public int deleteSubCategory(int no) {
		return categoryDao.deleteSubCategory(no);
	}
}
