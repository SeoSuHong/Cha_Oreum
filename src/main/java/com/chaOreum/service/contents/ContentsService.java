package com.chaOreum.service.contents;

import java.util.List;

import com.chaOreum.entity.Comment;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;

public interface ContentsService {

	// 게시물 리스트
	List<PostView> getViewList(int category_no, String nickname, String title, String sort, int page);
	// 마지막 페이지
	int getEndPage(int category_no, String nickname, String title);
	
	// detail 게시글
	Post getView(int no);
	
	// 좋아요 유무 체크
	int likeIsChecked(int no, String id);
	// 좋아요 클릭
	int likePost(int no, String id);
	// 좋아요 취소
	int unlikePost(int no, String id);
	// 댓글 가져오기
	List<Comment> getComments(int no);
	// 답글 가져오기
	List<Reply> getReplies(int no);
	// 댓글 작성
	int sendComment(int no, String nickname, String contents);
	// 답글 작성
	int sendReply(int no, String nickname, String contents);
	
}