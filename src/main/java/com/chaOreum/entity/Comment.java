package com.chaOreum.entity;

import java.util.Date;

public class Comment {
	private int no;
	private int post_no;
	private String member_nickname;
	private String contents;
	private Date regDate;
	private boolean comment_secret;
	
	public Comment() {}

	public Comment(int no, int post_no, String member_nickname, String contents, Date regDate, boolean comment_secret) {
		this.no = no;
		this.post_no = post_no;
		this.member_nickname = member_nickname;
		this.contents = contents;
		this.regDate = regDate;
		this.comment_secret = comment_secret;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
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

	public boolean getComment_secret() {
		return comment_secret;
	}

	public void setComment_secret(boolean comment_secret) {
		this.comment_secret = comment_secret;
	}

	@Override
	public String toString() {
		return "Comment [no=" + no + ", post_no=" + post_no + ", member_nickname=" + member_nickname + ", contents="
				+ contents + ", regDate=" + regDate + ", comment_secret=" + comment_secret + "]";
	}
	
}