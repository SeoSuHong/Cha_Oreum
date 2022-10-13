package com.chaOreum.dao.contents;

import java.util.List;

import com.chaOreum.entity.PostView;

public interface ContentsDao {

	List<PostView> getViewList(int category_no, String nickname, String title, String sort, int offset, int size);
	int getEndPage(int category_no, String nickname, String title);

}
