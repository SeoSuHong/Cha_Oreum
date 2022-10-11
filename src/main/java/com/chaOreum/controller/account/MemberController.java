package com.chaOreum.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaOreum.entity.Member;
import com.chaOreum.service.account.MemberService;

@Controller
@RequestMapping("/account/")
public class MemberController {
	
	@Autowired
	MemberService memberService; // -> serviceImp -> dao -> daoImp(mybatis)

	@GetMapping("logIn")
	public String logIn() {
		return "account.logIn";
	}
	
	@PostMapping("logIn")
	public String logIn(String id, String password) {
		
		Member member = memberService.get(id, password);
		System.out.println("nickname : " + member.getNickname() + ", email : " + member.getEmail());
		
		return "";
	}
	
	@GetMapping("signUp")
	public String signUp() {
		return "account.signUp";
	}
	
	@GetMapping("findId")
	public String findId() {
		return "account.findId";
	}
	
	@GetMapping("findPw")
	public String findPw() {
		return "account.findPw";
	}
}
