package com.chaOreum.service.include;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.include.IncludeDao;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;

@Service
public class IncludeServiceImp implements IncludeService {
	
	@Autowired
	IncludeDao includeDao;
	
	@Override
	public List<MainCategory> getMainCategories() {
		return getMainCategories("");
	}
	
	@Override
	public List<SubCategory> getSubCategories() {
		return getSubCategories("");
	}
	
	@Override
	public List<MainCategory> getMainCategories(String nickname) {

		List<MainCategory> mainCategories = includeDao.getMainCategories(nickname);
		
		return mainCategories;
	}
	
	@Override
	public List<SubCategory> getSubCategories(String nickname) {
		
		List<SubCategory> subCategories = includeDao.getSubCategories(nickname);
		
		return subCategories;
	}
	
	@Override
	public List<SubCategory> getScByMc(int no) {

		List<SubCategory> subCategories = includeDao.getScByMc(no);
		
		return subCategories;
	}
}
