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
import com.chaOreum.entity.NoticeView;
import com.chaOreum.entity.Paging;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.board.contents.ContentsService;
import com.chaOreum.service.board.notice.NoticeService;
import com.chaOreum.service.include.IncludeService;

@Controller
public class HomeController {
	
	@Autowired
	private IncludeService includeService;
	
	@Autowired
	private ContentsService contentsService;
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session,
						@RequestParam(defaultValue = "0") int c,
						@RequestParam(required = false) String n,
						@RequestParam(required = false) String t,
						@RequestParam(required = false) String s,
						@RequestParam(defaultValue = "1") int p) {
		
		// aside
		String nickname = (String) session.getAttribute("nickname");
		
		List<MainCategory> mainCategories = null;
		List<SubCategory> subCategories = null;
		
		if(nickname == null || !nickname.equals(n)) {
			mainCategories = includeService.getMainCategories();
			subCategories = includeService.getSubCategories();
		} else if(nickname.equals(n)) {
			mainCategories = includeService.getMainCategories(nickname);
			subCategories = includeService.getSubCategories(nickname);
		}
		
		// main
		// 공지사항 가져오기
		List<NoticeView> noticeViewList = noticeService.getNoticeViewList();
		
		// parameter에 따른 post리스트 가져오기
		List<PostView> list = contentsService.getViewList(c, n, t, s, p);
		
		// 페이징
		int currPage = p;  // 현재 페이지
		int block_per_page = 5;  // 블럭 당 페이지 수
		int currBlock = currPage / block_per_page;  // 현재 블럭
		if(currPage % block_per_page > 0)
			currBlock++;
		int block_firstPage = (currBlock * block_per_page) - 4;  // 현재 블럭의 첫번째 페이지
		int block_endPage = block_firstPage + block_per_page - 1;  // 현재 블럭의 마지막 페이지
		int endPage = 0;  // 마지막 페이지
		int post_cnt = contentsService.getEndPage(c, n, t);  // 총 게시물 수
		int divPage = post_cnt / 10;
		float modPage = post_cnt % 10;
		
		if(modPage == 0)
			endPage = divPage;
		else
			endPage = divPage + 1;
		int endBlock = endPage / block_per_page;  // 마지막 페이지의 블럭
		if(endPage % block_per_page > 0)
			endBlock++;
		int endBlock_firstPage = (endBlock * block_per_page) - 4;
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("list", list);
		model.addAttribute("noticeViewList", noticeViewList);
		model.addAttribute("page", new Paging(endPage, block_firstPage, block_endPage, block_per_page, endBlock_firstPage));
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