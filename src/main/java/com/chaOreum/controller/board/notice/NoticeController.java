package com.chaOreum.controller.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.NoticeView;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.admin.notice.NoticeService;
import com.chaOreum.service.include.IncludeService;

@Controller
@RequestMapping("/board/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private IncludeService includeService;
	
	@GetMapping("detail")
	public String detail(int no, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		
		// main
		NoticeView notice = noticeService.getView(no);
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("notice", notice);
		System.out.println("no : " + no);
		return "board.notice.detail";
	}

}
