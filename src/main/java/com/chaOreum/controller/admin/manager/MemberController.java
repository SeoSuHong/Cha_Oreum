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

import com.chaOreum.entity.Member;
import com.chaOreum.entity.Paging;
import com.chaOreum.service.admin.member.MemberService;

@Controller("adminMemberController")
@RequestMapping("/admin/manager/member/")
public class MemberController {
	
	@Autowired
	private MemberService adminmemberDao;
	
	@GetMapping("view")
	public String member(Model model, HttpSession session,
			@RequestParam(required = false) String e,
			@RequestParam(required = false) String n,
			@RequestParam(required = false) String i,
			@RequestParam(defaultValue = "1") int p) {
		
		//권한 확인
		boolean role = false;
		if(session.getAttribute("admin") != null)
			role = (boolean) session.getAttribute("admin");
		if(!role) return "/admin/notAdmin";
		
		String nid = (String) session.getAttribute("id");
		
		List<Member> MemberList = adminmemberDao.getMemberList(nid, e, n, i, p);
		
		// 페이징
				int currPage = p;  // 현재 페이지
				int block_per_page = 5;  // 블럭 당 페이지 수
				int currBlock = currPage / block_per_page;  // 현재 블럭
				if(currPage % block_per_page > 0)
					currBlock++;
				int block_firstPage = (currBlock * block_per_page) - 4;  // 현재 블럭의 첫번째 페이지
				int block_endPage = block_firstPage + block_per_page - 1;  // 현재 블럭의 마지막 페이지
				int endPage = 0;  // 마지막 페이지
				int member_cnt = adminmemberDao.getEndPage(nid, e, n, i);  // 총 회원수
				int divPage = member_cnt / 10;
				float modPage = member_cnt % 10;
				
				if(modPage == 0)
					endPage = divPage;
				else
					endPage = divPage + 1;
				int endBlock = endPage / block_per_page;  // 마지막 페이지의 블럭
				if(endPage % block_per_page > 0)
					endBlock++;
				int endBlock_firstPage = (endBlock * block_per_page) - 4;
		
		model.addAttribute("MemberList", MemberList);
		model.addAttribute("e", e);
		model.addAttribute("n", n);
		model.addAttribute("i", i);
		model.addAttribute("p", p);
		model.addAttribute("member_cnt", member_cnt);  // 총 게시물 수
		model.addAttribute("page", new Paging(endPage, block_firstPage, block_endPage, block_per_page, endBlock_firstPage));
		
		return "admin.manager.member.member";
	}
	
	@ResponseBody
	@GetMapping("delete")
	public String delete(String id) {
		
		String messege = "<script>alert('추방에 실패하였습니다.'); history.go(-1);</script>";
		
		if(adminmemberDao.deleteMember(id))
			messege = "<script>alert('추방에 성공하였습니다.'); location.href='view';</script>";
		
		return messege;
	}
	
	@ResponseBody
	@GetMapping("upgrade")
	public String upgrade(String id, String role_) {
		
		String role = "";
		
		String messege = "<script>alert('권한 변경에 실패하였습니다.'); history.go(-1);</script>";
		
		if(role_.equals("admin")||role_ == "admin") role = "user";
		if(role_.equals("user")||role_ == "user") role = "admin";
		
		if(adminmemberDao.upgradeMember(id, role))
			messege = "<script>alert('권한 변경에 성공하였습니다.'); location.href='view';</script>";
		
		return messege;
	}
	
}
