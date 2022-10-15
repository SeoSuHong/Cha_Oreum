package com.chaOreum.service.contents;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.chaOreum.entity.PostView;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ContentsServiceTest {

	@Autowired
	ContentsService contentsService;
	
	@Test
	void 게시글_리스트() {
		List<PostView> list = contentsService.getViewList(0, null, null, null, 1);
		
		for(PostView post : list)
			System.out.println(post);
	}
	
	@Test
	void 좋아요_클릭여부() {
		// 1 : 클릭O   |   0 : 클릭X
		int like_isChecked = contentsService.likeIsChecked(35, "suhong");
		
		System.out.println(like_isChecked);
	}

	@Test
	void 좋아요_클릭() {
		// 1 : 좋아요 성공   |   0 : 좋아요 실패
		int likePost = contentsService.likePost(36, "suhong");
		
		System.out.println(likePost);
	}
	
	@Test
	void 좋아요_취소_클릭() {
		// 1 : 좋아요 취소 성공   |   0 : 좋아요 취소 실패
		int unlikePost = contentsService.unlikePost(35, "suhong");
		
		System.out.println(unlikePost);
	}
}
