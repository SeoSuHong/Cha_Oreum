package com.chaOreum.service.include;

import java.util.List;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

public interface IncludeService {
	
	public List<MainCategory> getMainCategories();
	public List<SubCategory> getSubCategories();
	public List<MainCategory> getMainCategories(String nickname);
	public List<SubCategory> getSubCategories(String nickname);

}
