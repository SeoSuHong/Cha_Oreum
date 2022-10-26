package com.chaOreum.service.admin.post;

import java.util.List;

import com.chaOreum.entity.PostView;

public interface PostService {

	// 검색 키워드에 따른 게시글 전부 가져오기
	List<PostView> getViewList(String category, String title, String id, int page);
	// 게시글 총 갯수
	int getEndPage(String category, String title, String id);
	// 게시글 삭제
	int delete(int no);

}
