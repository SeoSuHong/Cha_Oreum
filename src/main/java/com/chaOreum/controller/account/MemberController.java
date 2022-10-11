package com.chaOreum.controller.account;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String logIn(String id, String password, HttpSession session, HttpServletResponse response) {
		String message = "";
		Member member = memberService.get(id, password);
		
		if(member != null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("nickname", member.getNickname());
			
			message = "<script>alert('" + member.getNickname() + "님 어서오세요.'); location.href='/';</script>";
		} else {
			message = "<script>alert('회원 정보가 일치하지 않습니다.\\n아이디 혹은 비밀번호를 확인해 주세요.'); history.go(-1);</script>";
		}
		
		return message;
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
