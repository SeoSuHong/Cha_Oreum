package com.chaOreum.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.aspect.RoleCheck;
import com.chaOreum.service.admin.notice.NoticeService;
import com.chaOreum.service.contents.ContentsService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ContentsService contentsService;
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/notAdmin")
	@ResponseBody
	public String notAdmin() {
		String message = "<script>alert('권한이 없습니다.'); location.href='/';</script>";
		
		return message;
	}
	
	@RoleCheck
	@GetMapping("")
	public String index(HttpSession session) {
		
		return "admin.index";
	}
}
