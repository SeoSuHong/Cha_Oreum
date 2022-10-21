package com.chaOreum.controller.admin.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")
@RequestMapping("/admin/manager/member/")
public class MemberController {

	@GetMapping("view")
	public String member() {
		
		return "admin.manager.member.member";
	}
	
}
