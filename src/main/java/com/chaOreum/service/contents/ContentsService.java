package com.chaOreum.service.contents;

import java.util.List;

import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;

public interface ContentsService {

	List<PostView> getViewList(int category_no, String nickname, String title, String sort, int page);
	int getEndPage(int category_no, String nickname, String title);
	
	Post getView(int no);
	int likeIsChecked(int no, String id);
	
}