package com.chaOreum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chaOreum.entity.SubCategoryView;
import com.chaOreum.service.contents.ContentsService;

@Controller
public class HomeController {
	
	@Autowired
	ContentsService postService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<String> mainCategories = postService.getMainCategories();
		model.addAttribute("mainCategories", mainCategories);
		
		List<SubCategoryView> subCategories = postService.getSubCategories();
		model.addAttribute("subCategories", subCategories);
		
		return "home.index";
	}

	@PostMapping("/")
	public String index(HttpSession session) {
		
//		session.removeAttribute("id");
//		session.removeAttribute("nickname");
		session.invalidate();
		
		return "redirect:/";
	}
}