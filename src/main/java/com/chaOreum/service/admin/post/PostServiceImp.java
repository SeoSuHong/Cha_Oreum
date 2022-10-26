package com.chaOreum.service.admin.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.admin.PostDao;
import com.chaOreum.entity.PostView;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Override
	public List<PostView> getViewList(String category, String title, String id, int page) {
		int size = 10;
		int offset = 0+(page-1)*size;  // page 1->0, 2->10, 3->20 an=a1+(n-1)d -> 0+(page-1)*10
		
		return postDao.getViewList(category, title, id, page, offset, size);
	}
	
	@Override
	public int getEndPage(String category, String title, String id) {
		return postDao.getEndPage(category, title, id);
	}
	
	@Override
	public int delete(int no) {
		return postDao.delete(no);
	}

}
