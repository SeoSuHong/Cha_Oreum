package com.chaOreum.dao.notice;

import java.util.List;

import com.chaOreum.entity.NoticeView;

public interface NoticeDao {

	List<NoticeView> getNoticeViewList();

	NoticeView getView(int no);

}
