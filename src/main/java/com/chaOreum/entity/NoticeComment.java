package com.chaOreum.entity;

import java.util.Date;

public class NoticeComment {
	private int no;
	private int notice_no;
	private String member_nickname;
	private String contents;
	private Date regDate;
	
	public NoticeComment() {}

	public NoticeComment(int no, int notice_no, String member_nickname, String contents, Date regDate) {
		super();
		this.no = no;
		this.notice_no = notice_no;
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

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
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

	@Override
	public String toString() {
		return "NoticeComment [no=" + no + ", notice_no=" + notice_no + ", member_nickname=" + member_nickname
				+ ", contents=" + contents + ", regDate=" + regDate + "]";
	}
}