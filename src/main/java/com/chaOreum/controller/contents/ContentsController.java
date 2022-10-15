package com.chaOreum.controller.contents;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	private IncludeService includeService;
	
	@Autowired
	private ContentsService contentsService;
	
	@Autowired
	private ServletContext ctx;

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
	
	@PostMapping("reg")
	@ResponseBody
	public String reg(int subCategory, String title, String contents, @RequestParam(required = false) MultipartFile[] files, @RequestParam(required = false) MultipartFile[] attachments, HttpSession session) throws IllegalStateException, IOException {
		String nickname = (String) session.getAttribute("nickname");

		// contents image 처리
		String id = (String) session.getAttribute("id");
		for(MultipartFile file : files) {
			String fileName = id + "_" + file.getOriginalFilename();
			
			String filePath = "/static/contents_img";
			String realPath = ctx.getRealPath(filePath);
			
			File savePath = new File(realPath);
			if(!savePath.exists()) savePath.mkdirs();
			
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			
			file.transferTo(saveFile);
		}
		
		// contents_img_remove 파일 전부 삭제
		String removePath = "/static/contents_img_remove";
		String removeRealPath = ctx.getRealPath(removePath);
		File removeFile = new File(removeRealPath);
		FileUtils.cleanDirectory(removeFile);
		
		// contents 내용 img 경로 변경
		contents = contents.replaceAll("contents_img_remove", "contents_img");
		
		// 첨부파일 처리
		StringBuffer fileName = new StringBuffer();
		StringBuffer fileSize = new StringBuffer();
		String fileName_ = "";
		
		for(int i = 0; i < attachments.length; i++) {
			MultipartFile file = attachments[i];
			
			fileName_ = file.getOriginalFilename();
					
			if(i != attachments.length-1) {
				fileName.append(file.getOriginalFilename());
				fileName.append("/");
				
				fileSize.append(file.getSize());
				fileSize.append("/");
			} else {
				fileName.append(file.getOriginalFilename());
				fileSize.append(file.getSize());
			}
			
			String filePath = "/static/post_attachments";
			String realPath = ctx.getRealPath(filePath);
			
			// 업로드하기 위한 경로가 없을 경우 생성
			File savePath = new File(realPath);
			if(!savePath.exists()) savePath.mkdirs();

			realPath += File.separator + fileName_;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
		}
		
		String message = "";
		Post post = new Post(0, id, subCategory, title, contents, null, fileName.toString(), fileSize.toString(), 0);
		if(contentsService.insertPost(post) == 1) {
			message = "<script>alert('게시글을 작성하였습니다.'); location.href='/?c=" + subCategory + "&n=" + nickname + "' ; </script>";
		} else {
			message = "<script>alert('게시글 작성에 실패하였습니다.\n다시 시도해 주세요.'); location.href='/?c=" + subCategory + "&n=" + nickname + "' ; </script>";
		}
		
		return message;
	}
	
	// 메인 카테고리 선택 시 서브 카테고리 가져오기
	@PostMapping("getScByMc")
	@ResponseBody
	public List<SubCategory> getScByMc(int no) {
		
		List<SubCategory> subCategories = includeService.getScByMc(no);
		
		return subCategories;
	}
	
	@PostMapping("contents_fileUpload")
	@ResponseBody
	public String editor_fileUpload(MultipartFile file, String id) throws IllegalStateException, IOException {
		
		// 업로드할 폴더 경로
		String filePath = "/static/contents_img_remove";
		String realPath = ctx.getRealPath(filePath);

		// 업로드할 파일 이름
		String org_fileName = file.getOriginalFilename();
		String str_fileName = id + "_" + org_fileName;

		// 업로드하기 위한 경로가 없을 경우 생성
		File savePath = new File(realPath);
		if (!savePath.exists()) savePath.mkdirs();
		
		realPath += File.separator + str_fileName;
		File saveFile = new File(realPath);
		file.transferTo(saveFile);
		
		String result = filePath + File.separator + str_fileName;

		return result;
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