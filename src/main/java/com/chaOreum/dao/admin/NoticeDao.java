package com.chaOreum.dao.admin;

import java.util.List;

import com.chaOreum.entity.Notice;
import com.chaOreum.entity.NoticeComment;
import com.chaOreum.entity.NoticeReply;
import com.chaOreum.entity.NoticeView;

public interface NoticeDao {
	List<NoticeView> getViewList();

	NoticeView getView(int no);

	int delete(int no);

	int set(Notice notice);

	int edit(Notice notice);

	List<NoticeComment> getComments(int no);

	List<NoticeReply> getReplies(int no);

	int setComment(NoticeComment comment);

	int setReply(NoticeReply reply);

	int commentDelete(int no);

	int replyDelete(int no);

}
