package com.chaOreum.controller.contents;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.entity.Comment;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.Reply;
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
		
		List<Comment> comments = contentsService.getComments(no);  // 게시글의 댓글
		List<Reply> replies = contentsService.getReplies(no);  // 게시글의 답글
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("post", post);
		model.addAttribute("like_isChecked", like_isChecked);
		model.addAttribute("comments", comments);
		model.addAttribute("replies", replies);
		
		return "contents.detail";
	}
	
	@PostMapping("like")
	@ResponseBody
	public boolean like(int no, String id, String l) {
		boolean check = false;
		
		try {
			if(l.equals("like")) {
				int result = contentsService.likePost(no, id);
				
				if(result == 1)
					check = true;
			} else if(l.equals("unlike")) {
				int result = contentsService.unlikePost(no, id);
				
				if(result == 1)
					check = true;
			}
			
		} catch(Exception e) {
			System.out.println("likePost Error : " + e.getMessage());
		}
		
		return check;
	}
	
	// 댓글 작성
	@PostMapping("comment")
	@ResponseBody
	public boolean comment(int no, String nickname, String contents) {
		boolean result = false;
		
		try {
			int sendComment = contentsService.sendComment(no, nickname, contents);
			if(sendComment == 1)
				result = true;
		} catch(Exception e) {
			System.out.println("sendComment Error : " + e.getMessage());
		}
		
		return result;
	}
	
	// 답글 작성
	@PostMapping("reply")
	@ResponseBody
	public boolean reply(int no, String nickname, String contents) {
		boolean result = false;
		
		try {
			int sendReply = contentsService.sendReply(no, nickname, contents);
			if(sendReply == 1)
				result = true;
		} catch(Exception e) {
			System.out.println("sendReply Error : " + e.getMessage());
		}
		
		return result;
	}
	
	// 댓글 삭제
	@PostMapping("delete_comment")
	@ResponseBody
	public boolean delete_comment(int no) {
		boolean result = false;
		
		try {
			int deleteReplies = contentsService.deleteReplies(no);
			int deleteComment = contentsService.deleteComment(no);
			
			if(deleteComment == 1)
				result = true;
		} catch(Exception e) {
			System.out.println("deleteComment Error : " + e.getMessage());
		}
		
		return result;
	}
	
	// 답글 삭제
	@PostMapping("delete_reply")
	@ResponseBody
	public boolean delete_reply(int no) {
		boolean result = false;
		
		try {
			int delete_reply = contentsService.deleteReply(no);
			if(delete_reply == 1)
				result = true;
		} catch(Exception e) {
			System.out.println("deleteReply Error : " + e.getMessage());
		}
			
		return result;
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
	
	// 메인 카테고리 선택 시 서브 카테고리 가져오기
	@PostMapping("getScByMc")
	@ResponseBody
	public List<SubCategory> getScByMc(int no) {
		
		List<SubCategory> subCategories = includeService.getScByMc(no);
		
		return subCategories;
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