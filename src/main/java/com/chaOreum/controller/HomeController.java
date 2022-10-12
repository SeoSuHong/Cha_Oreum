package com.chaOreum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.contents.ContentsService;
import com.chaOreum.service.include.IncludeService;

@Controller
public class HomeController {
	
	@Autowired
	IncludeService includeService;
	
	@Autowired
	ContentsService contentsService;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session,
						@RequestParam(required = false) Integer c,
						@RequestParam(required = false) String t,
						@RequestParam(required = false) String n,
						@RequestParam(required = false) String s,
						@RequestParam(defaultValue = "1") int p) {
		
		String nickname = (String) session.getAttribute("nickname");
		
		List<MainCategory> mainCategories = null;
		List<SubCategory> subCategories = null;
		
		if(nickname.equals(n)) {
			mainCategories = includeService.getMainCategories(nickname);
			subCategories = includeService.getSubCategories(nickname);
		} else {
			mainCategories = includeService.getMainCategories();
			subCategories = includeService.getSubCategories();
		}
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("c", c);
		model.addAttribute("t", t);
		model.addAttribute("n", n);
		model.addAttribute("s", s);
		model.addAttribute("p", p);
		
		return "home.index";
	}

	@PostMapping("/")
	@ResponseBody
	public String index(HttpSession session) {
		
		session.invalidate();
		
		return "<script>alert('로그아웃 되었습니다.'); location.href='/';</script>";
	}
}