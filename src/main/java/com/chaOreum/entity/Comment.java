package com.chaOreum.entity;

public class Comment {
	private int no;
	private int post_no;
	private String member_nickname;
	private String contents;
	
	public Comment() {}

	public Comment(int no, int post_no, String member_nickname, String contents) {
		this.no = no;
		this.post_no = post_no;
		this.member_nickname = member_nickname;
		this.contents = contents;
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

	@Override
	public String toString() {
		return "Comment [no=" + no + ", post_no=" + post_no + ", member_nickname=" + member_nickname + ", contents="
				+ contents + "]";
	}
}