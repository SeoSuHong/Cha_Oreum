package com.chaOreum.service.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.SubCategoryView;

@Service
public class ContentsServiceImp implements ContentsService {

	@Autowired
	ContentsDao postDao;
	
	@Override
	public List<String> getMainCategories() {

		List<String> mainCategories = postDao.getMainCategories();
		
		return mainCategories;
	}
	
	@Override
	public List<SubCategoryView> getSubCategories() {
		
		List<SubCategoryView> subCategories = postDao.getSubCategories();
		
		return subCategories;
	}

}
