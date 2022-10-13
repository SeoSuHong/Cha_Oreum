package com.chaOreum.controller.account;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@ResponseBody
	@PostMapping("signUp")
	public String signUp(String id, String nickname, String password, String email_front, String email_back, String email) {
		
		email = email_front + "@" + email_back;
		
		String message = "";
		
		if(memberService.signup(id, nickname, password, email)) {
		
		message = "<script>alert('회원가입이 완료 되었습니다.'); location.href='/account/logIn';</script>";
		} else {
			message = "<script>alert('회원가입이 되지않았습니다.\\n회원가입을 다시 진행해 주세요.'); history.go(-1);</script>";
		}
		return message;
	}
	
	@GetMapping("findId")
	public String findId() {
		return "account.findId";
	}
	
	@ResponseBody
	@PostMapping("findId")
	public String findId(String email_front, String email_back, String email) {
		
		email = email_front + "@" + email_back;
		
		String message = "";
		
		Member member = memberService.findId(email);
		
		if(member != null) {
			
		message = "<script>alert('귀하의 ID는 \\'" + member.getId() + "\\' 입니다.'); location.href='/account/findId';</script>";
		} else {
			message = "<script>alert('가입되어있지 않은 이메일입니다.\\n회원가입을 해주세요.'); history.go(-1);</script>";
		}
		return message;
	}
	
	@GetMapping("findPw")
	public String findPw() {
		return "account.findPw";
	}
	
	@GetMapping("info")
	public String info(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		Member getMemberInfo = memberService.getInfo(id);
		
		model.addAttribute("getMemberInfo", getMemberInfo);
		return "account.info";
	}
	
	@GetMapping("infoReg")
	public String infoReg(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		Member getMemberInfo = memberService.getInfo(id);
		
		model.addAttribute("getMemberInfo", getMemberInfo);
		return "account.infoReg";
	}
	
	@ResponseBody
	@PostMapping("infoReg")
	public String infoReg(String id, String nickname, String password, String email_front, String email_back, String email) {
			
		email = email_front + "@" + email_back;
		String message = "";
		
		if(memberService.updateInfo(id, nickname, password, email)) {
		
			message = "<script>alert('회원정보 수정이 완료 되었습니다.'); location.href='/account/info';</script>";
		} else {
			message = "<script>alert('회원정보 수정에 실패하였습니다.\\n다시 시도해주세요.'); history.go(-1);</script>";
		}
		return message;
	}
	
	//유효성 검사
	@ResponseBody
	@PostMapping("id_check")
	public int id_check(String id) {
		int result = memberService.id_check(id);
		return result;
	}
	
	@ResponseBody
	@PostMapping("nickname_check")
	public int nickname_check(String nickname) {
		int result = memberService.nickname_check(nickname);
		return result;
	}
	
	@ResponseBody
	@PostMapping("email_check")
	public int email_check(String email) {
		int result = memberService.email_check(email);
		return result;
	}
}
