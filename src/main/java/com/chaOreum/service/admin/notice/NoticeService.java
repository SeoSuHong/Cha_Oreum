package com.chaOreum.service.admin.notice;

import java.util.List;

import com.chaOreum.entity.Notice;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
import com.chaOreum.entity.NoticeView;

public interface NoticeService {
	// 모든 공지사항 가져오기
	List<NoticeView> getViewList();
	// no값에 맞는 공지사항 가져오기
	NoticeView getView(int no);
	// 공지사항 등록
	int set(Notice notice);
	// 댓글 모두 가져오기
	List<NoticeComment> getComments(int no);
	// 댓글의 모든 답글 가져오기
	List<NoticeReply> getReplies(int no);
	// 댓글 등록
	int setComment(NoticeComment comment);
	// 답글 등록
	int setReply(NoticeReply reply);
	// 댓글 삭제
	int commentDelete(int no);
	// 답글 삭제
	int replyDelete(int no);
	
	// 공지사항 삭제
	int delete(int no);
}
