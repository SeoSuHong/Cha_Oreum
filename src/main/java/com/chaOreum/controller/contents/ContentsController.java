package com.chaOreum.controller.contents;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.contents.ContentsService;
import com.chaOreum.service.include.IncludeService;

@Controller
@RequestMapping("/contents/")
public class ContentsController {
	
	@Autowired
	IncludeService includeService;
	
	@Autowired
	ContentsService contentsService;

	@GetMapping("detail")
	public String detail(Model model, HttpSession session, int no) {
		String id = (String) session.getAttribute("id");
		
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		
		// main
		Post post = contentsService.getView(no);  // 현재 게시글의 정보
		
		int like_isChecked = contentsService.likeIsChecked(no, id);  // 좋아요 클릭 여부
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("post", post);
		model.addAttribute("like_isChecked", like_isChecked);
		
		return "contents.detail";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "contents.reg";
	}
	
	@GetMapping("edit")
	public String edit(Model model) {
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "contents.edit";
	}	
}