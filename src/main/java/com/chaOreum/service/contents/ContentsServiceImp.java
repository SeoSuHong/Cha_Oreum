package com.chaOreum.service.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.contents.ContentsDao;
import com.chaOreum.entity.Post;

@Service
public class ContentsServiceImp implements ContentsService {

	@Autowired
	ContentsDao contentsDao;
	
	@Override
	public List<Post> getList(int category_no, String nickname, String title, String sort, int page) {

		int size = 10;
		int offset = 0+(page-1)*size;  // page 1->0, 2->10, 3->20 an=a1+(n-1)d -> 0+(page-1)*10
		
		List<Post> list = contentsDao.getList(category_no, nickname, title, sort, offset, size);
		
		return list;
	}
}