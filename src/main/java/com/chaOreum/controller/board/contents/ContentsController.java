package com.chaOreum.controller.board.contents;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chaOreum.entity.Comment;
import com.chaOreum.entity.MainCategory;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;
import com.chaOreum.entity.SubCategory;
import com.chaOreum.service.contents.ContentsService;
import com.chaOreum.service.include.IncludeService;
import com.chaOreum.service.util.RequestService;

@Controller
@RequestMapping("/board/contents/")
public class ContentsController {
	
	@Autowired
	private IncludeService includeService;
	
	@Autowired
	private ContentsService contentsService;
	
	@Autowired
	private ServletContext ctx;
	
	@Autowired
	private RequestService requestService;

	@GetMapping("detail")
	public String detail(int no, Model model, HttpSession session, HttpServletRequest request) {
		String id = (String) session.getAttribute("id");
		
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		
		// main
		String clientIPAddress = requestService.getClientIpAddress(request);  // 사용자 IP주소
		int viewCount = contentsService.setViewCount(no, clientIPAddress);
		if(viewCount == 1) {
			System.out.println("Increase ViewCount");
		}
		
		PostView post = contentsService.getView(no);  // 현재 게시글의 정보
		
		int like_isChecked = contentsService.likeIsChecked(no, id);  // 좋아요 클릭 여부
		
		List<Comment> comments = contentsService.getComments(no);  // 게시글의 댓글
		List<Reply> replies = contentsService.getReplies(no);  // 게시글의 답글
		
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("post", post);
		model.addAttribute("like_isChecked", like_isChecked);
		model.addAttribute("comments", comments);
		model.addAttribute("replies", replies);
		
		return "board.contents.detail";
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
	public boolean comment(int no, String nickname, String contents, boolean comment_secret) {
		boolean result = false;
		
		try {
			int sendComment = contentsService.sendComment(no, nickname, contents, comment_secret);
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
	public boolean reply(int no, String nickname, String contents, boolean reply_secret) {
		boolean result = false;
		
		try {
			int sendReply = contentsService.sendReply(no, nickname, contents, reply_secret);
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
	
	// 게시글 삭제
	@GetMapping("delete_post")
	@ResponseBody
	public String delete_post(int no, HttpSession session) {
		String nickname = (String) session.getAttribute("nickname");
		String message = "<script>alert('게시글 삭제에 실패하였습니다.\\n다시 시도해 주세요.'); history.go(-1);</script>";
		
		int delete = contentsService.deletePost(no);
		if(delete == 1) {
			message = "<script>alert('게시글을 삭제하였습니다.'); location.href='/?n=" + nickname + "'</script>";
		}
		
		return message;
	}
	
	@GetMapping("reg")
	public String reg(Model model, HttpSession session) {
		// aside
		String nickname = (String) session.getAttribute("nickname");
		if(nickname == null) {
			model.addAttribute("message", "로그인 후 이용할 수 있는 페이지입니다\\n로그인 페이지로 이동합니다.");
			model.addAttribute("url", "/account/logIn");
			return "/alert";
		}
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		return "board.contents.reg";
	}
	
	@PostMapping("reg")
	@ResponseBody
	public String reg(int subCategory, String title, String contents, @RequestParam(required = false) MultipartFile[] files, @RequestParam(required = false) MultipartFile[] attachments, HttpSession session) throws IllegalStateException, IOException {
		String nickname = (String) session.getAttribute("nickname");

		// contents image 처리
		String id = (String) session.getAttribute("id");
		for(MultipartFile file : files) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			String fileName = id + "_" + file.getOriginalFilename();
			
			String filePath = "/static/contents_img";
			String realPath = ctx.getRealPath(filePath);
			
			File savePath = new File(realPath);
			if(!savePath.exists()) savePath.mkdirs();
			
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			System.out.println(file.getOriginalFilename());
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
		
		for(MultipartFile file : attachments) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			fileName_ = file.getOriginalFilename();
			
			// DB에 입력될 fileName, fileSize
			fileName.append(file.getOriginalFilename());
			fileName.append("/");
			fileSize.append(file.getSize());
			fileSize.append("/");
			
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
		Post post = new Post(0, id, subCategory, title, contents, null, fileName.toString(), fileSize.toString());
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
	public String contents_fileUpload(MultipartFile file, String id) throws IllegalStateException, IOException {
		
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
	public String edit(int no, Model model) {
		// aside
		List<MainCategory> mainCategories = includeService.getMainCategories();
		List<SubCategory> subCategories = includeService.getSubCategories();
		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("subCategories", subCategories);
		
		// main
		PostView post = contentsService.getView(no);
		model.addAttribute("post", post);
		
		return "board.contents.edit";
	}
	
	@PostMapping("edit")
	@ResponseBody
	public String edit(int no, int subCategory, String title, String contents, HttpSession session,
						@RequestParam(required = false) String[] fileName,
						@RequestParam(required = false) String[] fileSize,
						@RequestParam(required = false) String[] remove_fileName,
						@RequestParam(required = false) MultipartFile[] attachments,
						@RequestParam(required = false) MultipartFile[] files) throws IllegalStateException, IOException {
		
		String message = "";
		String saveFileName = "";  // DB에 저장될 fileName
		String saveFileSize = "";  // DB에 저장될 fileSize
		
		String savePath = "/static/post_attachments";  // 저장 폴더
		String realPath = ctx.getRealPath(savePath);   // 저장 폴더 경로

		// 삭제하지 않은 파일들 saveFileName에 추가
		if(fileName != null) {
			for(int i = 0; i < fileName.length; i++) {
				saveFileName += fileName[i] + "/";  // a.txt/b.txt/c.txt/
				saveFileSize += fileSize[i] + "/";  // 1000/2000/3000/
			}
		}
		
		// 삭제한 파일들 저장 폴더에서 삭제
		if(remove_fileName != null) {
			for(int i = 0; i < remove_fileName.length; i++) {
				String removePath = realPath + File.separator + remove_fileName[i];  // 삭제 파일 경로
				
				File removeFile = new File(removePath);
				if(removeFile.exists()) removeFile.delete();  // 삭제 파일 존재할 경우 삭제
			}
		}
		
		// 추가한 파일들 저장 및 saveFileName에 추가
		for(MultipartFile file : attachments) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			
			String add_fileName = file.getOriginalFilename();
			long add_fileSize = file.getSize();
			
			saveFileName += add_fileName + "/";  // DB 저장 fileName에 추가
			saveFileSize += add_fileSize + "/";  // DB 저장 fileSize에 추가
			
			// 저장 폴더가 없을 시 생성
			File saveFile = new File(realPath);
			if(!saveFile.exists()) saveFile.mkdirs();
			
			String attachmentPath = realPath + File.separator + add_fileName;
			File attachment = new File(attachmentPath);
			file.transferTo(attachment);
		}
		
		// contents image 처리
		String id = (String) session.getAttribute("id");
		for(MultipartFile file : files) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			
			String fileName_ = id + "_" + file.getOriginalFilename();
			
			String filePath = "/static/contents_img";
			String realPath_ = ctx.getRealPath(filePath);
			
			File savePath_ = new File(realPath_);
			if(!savePath_.exists()) savePath_.mkdirs();
			
			realPath_ += File.separator + fileName_;
			File saveFile = new File(realPath_);

			file.transferTo(saveFile);
		}
		
		// contents_img_remove 파일 전부 삭제
		String removePath = "/static/contents_img_remove";
		String removeRealPath = ctx.getRealPath(removePath);
		File removeFile = new File(removeRealPath);
		FileUtils.cleanDirectory(removeFile);
		
		// contents 내용 img 경로 변경
		contents = contents.replaceAll("contents_img_remove", "contents_img");
		
		Post post = new Post(no, id, subCategory, title, contents, null, saveFileName, saveFileSize);
		int result = contentsService.editPost(post);
		
		if(result == 1) message = "<script>alert('게시글을 수정하였습니다.'); location.href='/board/contents/detail?no=" + no + "';</script>";
		else message = "<script>alert('게시글 수정에 실패하였습니다.\n다시 시도해 주세요.'); location.href='/board/contents/detail?no=" + no + "';</script>";
		
		return message;
	}
}



