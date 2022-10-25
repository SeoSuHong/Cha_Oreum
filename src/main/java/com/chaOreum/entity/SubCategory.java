package com.chaOreum.entity;

public class SubCategory {
	private int no;
	private int mainCategory_no;
	private String name;
	private int post_cnt;
	
	public SubCategory() {}

	public SubCategory(int no, int mainCategory_no, String name) {
		this.no = no;
		this.mainCategory_no = mainCategory_no;
		this.name = name;
	}
	
	public SubCategory(int no, int mainCategory_no, String name, int post_cnt) {
		super();
		this.no = no;
		this.mainCategory_no = mainCategory_no;
		this.name = name;
		this.post_cnt = post_cnt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMainCategory_no() {
		return mainCategory_no;
	}

	public void setMainCategory_no(int mainCategory_no) {
		this.mainCategory_no = mainCategory_no;
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

	@Override
	public String toString() {
		return "SubCategory [no=" + no + ", mainCategory_no=" + mainCategory_no + ", name=" + name + ", post_cnt="
				+ post_cnt + "]";
	}
}