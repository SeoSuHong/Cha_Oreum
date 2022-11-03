package com.chaOreum.controller.admin.manager;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.aspect.RoleCheck;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.admin.category.CategoryService;

@Controller
@RequestMapping("/admin/manager/category/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RoleCheck
	@GetMapping("view")
	public String category(Model model, HttpSession session) {
		
		List<MainCategory> mainList = categoryService.getMainList();
		List<SubCategory> subList = categoryService.getSubList();
		
		model.addAttribute("mainList", mainList);
		model.addAttribute("subList", subList);
		
		return "admin.manager.category.category";
	}
	
	// 메인 카테고리 생성
	@PostMapping("regMainCategory")
	@ResponseBody
	public boolean regMainCategory(String name) {
		int reg = categoryService.regMainCategory(name);
		
		if(reg == 1) return true;
		else return false;
	}
	
	// 메인 카테고리 이름 수정
	@PostMapping("editMainCategory")
	@ResponseBody
	public boolean editMainCategory(int no, String name) {
		int edit = categoryService.editMainCategory(no, name);
		if(edit == 1) return true;
		else return false;
	}
	
	// 메인 카테고리 삭제
	@PostMapping("deleteMainCategory")
	@ResponseBody
	public boolean deleteMainCategory(int no) {
		int delete = categoryService.deleteMainCategory(no);
		if(delete == 1) return true;
		else return false;
	}
	
	// 서브 카테고리 생성
	@PostMapping("regSubCategory")
	@ResponseBody
	public boolean regSubCategory(int mainCategory_no, String name) {
		int reg = categoryService.regSubCategory(mainCategory_no, name);
		
		if(reg == 1) return true;
		else return false;
	}
	
	// 서브 카테고리 이름 수정
	@PostMapping("editSubCategory")
	@ResponseBody
	public boolean editSubCategory(int no, int mainCategory_no, String name) {
		int edit = categoryService.editSubCategory(no, mainCategory_no, name);
		if(edit == 1) return true;
		else return false;
	}
	
	// 서브 카테고리 삭제
	@PostMapping("deleteSubCategory")
	@ResponseBody
	public boolean deleteSubCategory(int no) {
		int delete = categoryService.deleteSubCategory(no);
		if(delete == 1) return true;
		else return false;
	}
}
