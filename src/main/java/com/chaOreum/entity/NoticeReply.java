package com.chaOreum.entity;

import java.util.Date;

public class NoticeReply {
	private int no;
	private int noticeComment_no;
	private String member_nickname;
	private String contents;
	private Date regDate;
	
	public NoticeReply() {}

	public NoticeReply(int no, int noticeComment_no, String member_nickname, String contents, Date regDate) {
		super();
		this.no = no;
		this.noticeComment_no = noticeComment_no;
		this.member_nickname = member_nickname;
		this.contents = contents;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNoticeComment_no() {
		return noticeComment_no;
	}

	public void setNoticeComment_no(int noticeComment_no) {
		this.noticeComment_no = noticeComment_no;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}