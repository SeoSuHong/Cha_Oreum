package com.chaOreum.controller.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.include.IncludeService;

@Controller
@RequestMapping("/contents/")
public class ContentsController {
	
	@Autowired
	IncludeService includeService;

	@GetMapping("detail")
	public String detail(Model model) {
		
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "contents.detail";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "contents.reg";
	}
	
	@GetMapping("edit")
	public String edit(Model model) {
		
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "contents.edit";
	}	
}