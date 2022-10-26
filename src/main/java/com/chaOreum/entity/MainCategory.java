package com.chaOreum.entity;

public class MainCategory {
	private int no;
	private String name;
	private int post_cnt;
	
	public MainCategory() {}

	public MainCategory(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public MainCategory(int no, String name, int post_cnt) {
		this.no = no;
		this.name = name;
		this.post_cnt = post_cnt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPost_cnt() {
		return post_cnt;
	}

	public void setPost_cnt(int post_cnt) {
		this.post_cnt = post_cnt;
	}
}