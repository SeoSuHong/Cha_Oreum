package com.chaOreum.dao.admin;

import java.util.List;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

public interface CategoryDao {

	List<MainCategory> getMainList();

	List<SubCategory> getSubList();

	int editMainCategory(int no, String name);

	int regMainCategory(String name);

	int deleteMainCategory(int no);

	int regSubCategory(int mainCategory_no, String name);

	int editSubCategory(int no, int mainCategory_no, String name);

	int deleteSubCategory(int no);

}
