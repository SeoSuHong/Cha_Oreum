package com.chaOreum.service.contents;

import java.util.List;

import com.chaOreum.entity.SubCategoryView;

public interface ContentsService {

	List<String> getMainCategories();

	List<SubCategoryView> getSubCategories();

}