package com.chaOreum.controller.admin.manager;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaOreum.entity.Comment;
import com.chaOreum.entity.Paging;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;
import com.chaOreum.service.admin.post.PostService;
import com.chaOreum.service.contents.ContentsService;

@Controller
@RequestMapping("/admin/manager/post/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ContentsService contentsService;
	
	@GetMapping("view")
	public String post(Model model, HttpSession session,
			@RequestParam(required = false) String c,
			@RequestParam(required = false) String t,
			@RequestParam(required = false) String i,
			@RequestParam(defaultValue = "1") int p) {
		
		// 권한 확인
		boolean role = false;
		if(session.getAttribute("admin") != null)
			role = (boolean) session.getAttribute("admin");
		if(!role) return "/admin/notAdmin";
		
		List<PostView> list = postService.getViewList(c, t, i, p);
		
		// 페이징
		int currPage = p;  // 현재 페이지
		int block_per_page = 5;  // 블럭 당 페이지 수
		int currBlock = currPage / block_per_page;  // 현재 블럭
		if(currPage % block_per_page > 0)
			currBlock++;
		int block_firstPage = (currBlock * block_per_page) - 4;  // 현재 블럭의 첫번째 페이지
		int block_endPage = block_firstPage + block_per_page - 1;  // 현재 블럭의 마지막 페이지
		int endPage = 0;  // 마지막 페이지
		int post_cnt = postService.getEndPage(c, t, i);  // 총 게시물 수
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
		
		model.addAttribute("list", list);
		model.addAttribute("c", c);
		model.addAttribute("t", t);
		model.addAttribute("i", i);
		model.addAttribute("p", p);
		model.addAttribute("post_cnt", post_cnt);  // 총 게시물 수
		model.addAttribute("page", new Paging(endPage, block_firstPage, block_endPage, block_per_page, endBlock_firstPage));
		
		return "admin.manager.post.post";
	}
	
	@GetMapping("detail")
	public String detail(int no, Model model, HttpSession session) {
		// 권한 확인
		boolean role = false;
		if(session.getAttribute("admin") != null)
			role = (boolean) session.getAttribute("admin");
		if(!role) return "/admin/notAdmin";
		
		PostView post = contentsService.getView(no);
		
		List<Comment> comments = contentsService.getComments(no);
		List<Reply> replies = contentsService.getReplies(no);
		
		model.addAttribute("post", post);
		model.addAttribute("comments", comments);
		model.addAttribute("replies", replies);
		
		return "admin.manager.post.detail";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(int no) {
		String message = "";
		int delete = postService.delete(no);
		
		if(delete == 1) message = "<script>alert('게시글이 삭제되었습니다.'); location.href='view';</script>";
		else message = "<script>alert('게시글 삭제에 실패하였습니다.\n다시 시도해 주세요.'); history.go(-1);</script>";
		
		return message;
	}
}
