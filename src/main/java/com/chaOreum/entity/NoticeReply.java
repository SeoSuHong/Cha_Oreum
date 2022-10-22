package com.chaOreum.entity;

import java.util.Date;

public class NoticeReply {
	private int no;
	private int notice_no;
	private int comment_no;
	private String member_nickname;
	private String contents;
	private Date regDate;
	private boolean secret;
	
	public NoticeReply() {}

	public NoticeReply(int no, int notice_no, int comment_no, String member_nickname, String contents, Date regDate, boolean secret) {
		this.no = no;
		this.notice_no = notice_no;
		this.comment_no = comment_no;
		this.member_nickname = member_nickname;
		this.contents = contents;
		this.regDate = regDate;
		this.secret = secret;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
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
	
	public boolean isSecret() {
		return secret;
	}
	
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
}