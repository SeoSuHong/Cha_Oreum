package com.chaOreum.service.admin.category;

import java.util.List;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

public interface CategoryService {

	// 메인 카테고리 전부 가져오기
	List<MainCategory> getMainList();
	//서브 카테고리 전부 가져오기
	List<SubCategory> getSubList();
	// 메인 카테고리 생성
	int regMainCategory(String name);
	// 메인 카테고리 이름 수정
	int editMainCategory(int no, String name);
	// 메인 카테고리 삭제
	int deleteMainCategory(int no);
	
	// 서브 카테고리 생성
	int regSubCategory(int mainCategory_no, String name);
	// 서브 카테고리 수정
	int editSubCategory(int no, int mainCategory_no, String name);
	// 서브 카테고리 삭제
	int deleteSubCategory(int no);

}
