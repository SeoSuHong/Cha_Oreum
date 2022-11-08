package com.chaOreum.controller.admin.manager;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chaOreum.aspect.RoleCheck;
import com.chaOreum.entity.Notice;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
import com.chaOreum.entity.NoticeView;
import com.chaOreum.service.admin.notice.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/manager/notice/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RoleCheck
	@GetMapping("view")
	public String notice(Model model, HttpSession session) {
		List<NoticeView> list = noticeService.getViewList();
		
		model.addAttribute("list", list);
		
		return "admin.manager.notice.notice";
	}
	
	@RoleCheck
	@GetMapping("detail")
	public String detail(int no, Model model, HttpSession session) {
		NoticeView notice = noticeService.getView(no);
		List<NoticeComment> comments = noticeService.getComments(no);
		List<NoticeReply> replies = noticeService.getReplies(no);
		
		model.addAttribute("notice", notice);
		model.addAttribute("comments", comments);
		model.addAttribute("replies", replies);
		
		return "admin.manager.notice.detail";
	}
	
	@PostMapping("comment")
	@ResponseBody
	public boolean setComment(int no, String nickname, String contents, boolean secret) {
		
		NoticeComment comment = new NoticeComment(0, no, nickname, contents, null, secret);
		int insert = noticeService.setComment(comment);
		
		if(insert == 1) return true;
		else return false;
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public boolean commentDelete(int no) {
		int delete = noticeService.commentDelete(no);
		
		if(delete == 1) return true;
		else return false;
	}
	
	@PostMapping("reply")
	@ResponseBody
	public boolean setReply(int no, int comment_no, String nickname, String contents, boolean secret) {
		
		NoticeReply reply = new NoticeReply(0, no, comment_no, nickname, contents, null, secret);
		int insert = noticeService.setReply(reply);
		
		if(insert == 1) return true;
		else return false;
	}

	@PostMapping("replyDelete")
	@ResponseBody
	public boolean replyDelete(int no) {
		int delete = noticeService.replyDelete(no);
		
		if(delete == 1) return true;
		else return false;
	}
	
	@RoleCheck
	@GetMapping("reg")
	public String reg(HttpSession session) {
		
		return "admin.manager.notice.reg";
	}
	
	@PostMapping("reg")
	@ResponseBody
	public String reg(String title, String contents, MultipartFile[] files, HttpSession session) throws IllegalStateException, IOException {
		String message = "";
		String id = (String) session.getAttribute("id");

		// contents image 처리
		for(MultipartFile file : files) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			String fileName = id + "_" + file.getOriginalFilename();
			
			String filePath = "/home/ubuntu/chaOreum/images/notice_img";
//			String realPath = ctx.getRealPath(filePath);
			
			File savePath = new File(filePath);
			if(!savePath.exists()) savePath.mkdirs();
			
			filePath += File.separator + fileName;
			File saveFile = new File(filePath);
			
			file.transferTo(saveFile);
		}
		
		// notice_img_remove 파일 전부 삭제
		String removePath = "/home/ubuntu/chaOreum/images/notice_img_remove";
//		String removeRealPath = ctx.getRealPath(removePath);
		File removeFile = new File(removePath);
		FileUtils.cleanDirectory(removeFile);
		
		// contents 내용 img 경로 변경
		contents = contents.replaceAll("notice_img_remove", "notice_img");
		
		Notice notice = new Notice(0, id, title, contents, null);
		int result = noticeService.set(notice);
		if(result == 1)
			message = "<script>alert('공지사항을 작성하였습니다.'); location.href='view';</script>";
		else
			message = "<script>alert('공지사항 작성에 실패하였습니다.\\n다시 시도해 주세요.'); history.go(-1);</script>";
		
		return message;
	}
	
	@RoleCheck
	@GetMapping("edit")
	public String edit(int no, Model model, HttpSession session) {
		
		Notice notice = noticeService.getView(no);
		
		model.addAttribute("notice", notice);
		
		return "admin.manager.notice.edit";
	}
	
	@PostMapping("edit")
	@ResponseBody
	public String edit(int no, String title, String contents, MultipartFile[] files, HttpSession session) throws IOException {
		String message = "";
		
		// contents image 처리
		String id = (String) session.getAttribute("id");
		for(MultipartFile file : files) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) continue;
			
			String fileName = id + "_" + file.getOriginalFilename();
			
			String savePath = "/home/ubuntu/chaOreum/images/notice_img";  // 저장 폴더
//			String realPath = ctx.getRealPath(savePath);   // 저장 폴더 경로

			File save = new File(savePath);
			if(!save.exists()) save.mkdirs();
			
			savePath += File.separator + fileName;
			File saveFile = new File(savePath);

			file.transferTo(saveFile);
		}
		
		// contents_img_remove 파일 전부 삭제
		String removePath = "/home/ubuntu/chaOreum/images/notice_img_remove";
//		String removeRealPath = ctx.getRealPath(removePath);
		File removeFile = new File(removePath);
		FileUtils.cleanDirectory(removeFile);
		
		// contents 내용 img 경로 변경
		contents = contents.replaceAll("notice_img_remove", "notice_img");
		
		Notice notice = new Notice(no, id, title, contents, null);
		int update = noticeService.edit(notice);
		
		if(update == 1) message = "<script>alert('공지사항을 수정하였습니다.'); location.href='detail?no=" + no + "';</script>";
		else message = "<script>alert('공지사항 수정에 실패하였습니다.\n다시 시도해 주세요.'); location.href='history.go(-1)';</script>";
		
		
		return message;
	}
	
	@PostMapping("notice_fileUpload")
	@ResponseBody
	public String notice_fileUpload(MultipartFile file, String id) throws IllegalStateException, IOException {

		// 업로드할 폴더 경로
		String filePath = "/home/ubuntu/chaOreum/images/notice_img_remove";
//		String realPath = ctx.getRealPath(filePath);

		// 업로드할 파일 이름
		String org_fileName = file.getOriginalFilename();
		String str_fileName = id + "_" + org_fileName;

		// 업로드하기 위한 경로가 없을 경우 생성
		File savePath = new File(filePath);
		if (!savePath.exists()) savePath.mkdirs();
		
		filePath += File.separator + str_fileName;
		File saveFile = new File(filePath);
		file.transferTo(saveFile);

		String mappingPath = "/notice_img_remove" + File.separator + str_fileName;
		
		return mappingPath;
	}
	
	@RoleCheck
	@GetMapping("delete")
	@ResponseBody
	public String delete(int no) {
		String message = "";
		
		int result = noticeService.delete(no);
		if(result == 1)
			message = "<script>alert('삭제가 완료되었습니다.'); location.href='view';</script>";
		else
			message = "<script>alert('삭제에 실패하였습니다.\\n다시 시도해 주세요.'); location.href='view';</script>";
		return message;
	}
}
