package com.chaOreum.controller.admin.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/manager/post/")
public class PostController {

	@GetMapping("view")
	public String post() {
		
		return "admin.manager.post.post";
	}
	
}
