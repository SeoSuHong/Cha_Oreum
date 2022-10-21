package com.chaOreum.service.board.notice;

import java.util.List;

import com.chaOreum.entity.NoticeView;

public interface NoticeService {

	List<NoticeView> getNoticeViewList();

	NoticeView getView(int no);

}
