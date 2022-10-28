package com.chaOreum.controller.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
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
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		
		// main
		NoticeView notice = noticeService.getView(no);
		List<NoticeComment> comments = noticeService.getComments(no);
		List<NoticeReply> replies = noticeService.getReplies(no);
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("notice", notice);
		model.addAttribute("comments", comments);
		model.addAttribute("replies", replies);
		
		return "board.notice.detail";
	}

	@PostMapping("comment")
	@ResponseBody
	public boolean setComment(int no, String nickname, String contents, boolean secret) {
		
		NoticeComment comment = new NoticeComment(0, no, nickname, contents, null, secret);
		int insert = noticeService.setComment(comment);
		
		if(insert == 1) return true;
		else return false;
	}
	
	@PostMapping("deleteComment")
	@ResponseBody
	public boolean deleteComment(int no) {
		int delete = noticeService.commentDelete(no);
		
		if(delete == 1) return true;
		else return false;
	}
	
	@PostMapping("reply")
	@ResponseBody
	public boolean setReply(int notice_no, int comment_no, String nickname, String contents, boolean secret) {
		
		NoticeReply reply = new NoticeReply(0, notice_no, comment_no, nickname, contents, null, secret);
		int insert = noticeService.setReply(reply);
		
		if(insert == 1) return true;
		else return false;
	}

	@PostMapping("deleteReply")
	@ResponseBody
	public boolean deleteReply(int no) {
		int delete = noticeService.replyDelete(no);
		
		if(delete == 1) return true;
		else return false;
	}
}
