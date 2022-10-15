package com.chaOreum.dao.contents;

import java.util.List;

import com.chaOreum.entity.Comment;
import com.chaOreum.entity.Post;
import com.chaOreum.entity.PostView;
import com.chaOreum.entity.Reply;

public interface ContentsDao {

	List<PostView> getViewList(int category_no, String nickname, String title, String sort, int offset, int size);
	int getEndPage(int category_no, String nickname, String title);
	
	Post getView(int no);
	int likeCount(int no, String id);
	int insertHot(int no, String id);
	int deleteHot(int no, String id);
	List<Comment> getComments(int no);
	List<Reply> getReplies(int no);
	int insertComment(int no, String nickname, String contents);
	int insertReply(int no, String nickname, String contents);

}
