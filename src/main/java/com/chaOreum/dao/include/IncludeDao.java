package com.chaOreum.dao.include;

import java.util.List;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

public interface IncludeDao {

	List<MainCategory> getMainCategories();
	List<SubCategory> getSubCategories();
	List<MainCategory> getMainCategories(String nickname);
	List<SubCategory> getSubCategories(String nickname);

}
