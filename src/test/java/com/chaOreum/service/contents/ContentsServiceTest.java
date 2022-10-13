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

}