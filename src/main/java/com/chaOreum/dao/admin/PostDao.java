package com.chaOreum.dao.admin;

import java.util.List;

import com.chaOreum.entity.PostView;

public interface PostDao {

	List<PostView> getViewList(String category, String title, String id, int page, int offset, int size);

	int getEndPage(String category, String title, String id);

	int delete(int no);

}
