package com.chaOreum.entity;

public class Hot {
	private int no;
	private String member_id;
	private int post_no;
	
	public Hot() {}

	public Hot(int no, String member_id, int post_no) {
		super();
		this.no = no;
		this.member_id = member_id;
		this.post_no = post_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	@Override
	public String toString() {
		return "Hot [no=" + no + ", member_id=" + member_id + ", post_no=" + post_no + "]";
	}	
}