package com.chaOreum.entity;

public class Reply {
	private int no;
	private int comment_no;
	private String member_nickname;
	private String contents;
	
	public Reply() {}

	public Reply(int no, int comment_no, String member_nickname, String contents) {
		this.no = no;
		this.comment_no = comment_no;
		this.member_nickname = member_nickname;
		this.contents = contents;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "Reply [no=" + no + ", comment_no=" + comment_no + ", member_nickname=" + member_nickname + ", contents="
				+ contents + "]";
	}
}