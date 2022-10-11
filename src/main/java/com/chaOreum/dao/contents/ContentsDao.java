package com.chaOreum.dao.contents;

import java.util.List;

import com.chaOreum.entity.SubCategoryView;

public interface ContentsDao {

	List<String> getMainCategories();

	List<SubCategoryView> getSubCategories();
	
}
