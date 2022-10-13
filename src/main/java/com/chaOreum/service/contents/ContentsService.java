package com.chaOreum.service.contents;

import java.util.List;

import com.chaOreum.entity.Post;

public interface ContentsService {

	List<Post> getList(int category_no, String nickname, String title, String sort, int page);

	
	
}