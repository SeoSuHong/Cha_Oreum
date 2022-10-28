package com.chaOreum.service.contents;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import com.chaOreum.entity.PostView;
import com.chaOreum.service.contents.ContentsService;
import com.chaOreum.service.util.RequestService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
class ContentsServiceTest {

	@Autowired
	private ContentsService contentsService;
	
	@Autowired
	private RequestService requestService;
	
	private MockHttpServletRequest request;
	
	@Test
	void 게시글_리스트() {
		List<PostView> list = contentsService.getViewList(0, null, null, null, 1);
		
		for(PostView post : list)
			System.out.println(post);
	}
	
	@Test
	void 조회수_증가() {
		request = new MockHttpServletRequest();
		String clientIPAddress = requestService.getClientIpAddress(request);
		System.out.printf("Client Ip Address is : %s\n", clientIPAddress);
		
		int viewCount = contentsService.setViewCount(1, clientIPAddress);
		if(viewCount == 1) {
			System.out.println("Increase View Count!");
		} else {
			System.out.println("View Count did not change!");
		}
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
		//int likePost = contentsService.likePost(36, "suhong");
		
		//System.out.println(likePost);
	}
	
	@Test
	void 좋아요_취소_클릭() {
		// 1 : 좋아요 취소 성공   |   0 : 좋아요 취소 실패
		//int unlikePost = contentsService.unlikePost(35, "suhong");
		
		//System.out.println(unlikePost);
	}
	
	@Test
	void 답글_입력() {
		int result = contentsService.sendReply(1, "Dev_Hong", "답글 테스트 입니다.", false);
		
		System.out.println(result);
	}
}
