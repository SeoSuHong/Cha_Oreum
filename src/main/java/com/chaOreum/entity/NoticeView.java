package com.chaOreum.entity;

import java.util.Date;

public class NoticeView extends Notice {
	private String admin_nickname;
	
	public NoticeView() {}

	public NoticeView(int no, String admin_id, String admin_nickname, String title, String contents, Date regDate) {
		super(no, admin_id, title, contents, regDate);
		this.admin_nickname = admin_nickname;
	}

	public String getAdmin_nickname() {
		return admin_nickname;
	}

	public void setAdmin_nickname(String admin_nickname) {
		this.admin_nickname = admin_nickname;
	}
}