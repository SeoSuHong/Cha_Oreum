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

	List<NoticeComment> getComments(int no);

	List<NoticeReply> getReplies(int no);
}
