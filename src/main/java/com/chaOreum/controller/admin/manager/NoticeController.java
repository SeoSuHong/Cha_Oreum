package com.chaOreum.controller.admin.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminNoticeController")
@RequestMapping("/admin/manager/notice/")
public class NoticeController {

	@GetMapping("")
	public String notice() {
		System.out.println("notice 관리");
		return "admin.manager.notice.notice";
	}
	
}
