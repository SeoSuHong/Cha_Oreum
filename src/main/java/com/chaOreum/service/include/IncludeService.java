package com.chaOreum.service.include;

import java.util.List;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

public interface IncludeService {
	
	public List<MainCategory> getMainCategories();
	public List<SubCategory> getSubCategories();
	public List<MainCategory> getMainCategories(String nickname);
	public List<SubCategory> getSubCategories(String nickname);
	// 메인 카테고리no에 따른 서브 카테고리
	List<SubCategory> getScByMc(int no);

}
