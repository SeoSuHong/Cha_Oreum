package com.chaOreum.controller.admin.manager;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chaOreum.entity.PostView;
import com.chaOreum.service.contents.ContentsService;

@Controller
@RequestMapping("/admin/manager/post/")
public class PostController {

	@Autowired
	private ContentsService contentsService;
	
	@GetMapping("view")
	public String post(Model model, HttpSession session,
			@RequestParam(defaultValue = "0") int c,
			@RequestParam(required = false) String n,
			@RequestParam(required = false) String t,
			@RequestParam(required = false) String s,
			@RequestParam(defaultValue = "1") int p) {
		
		List<PostView> list = contentsService.getViewList(c, n, t, s, p);
		
		model.addAttribute("list", list);
		
		return "admin.manager.post.post";
	}
	
}
