package com.chaOreum.entity;

public class SubCategory {
	private int no;
	private int mainCategory_no;
	private String name;
	
	public SubCategory() {}

	public SubCategory(int no, int mainCategory_no, String name) {
		super();
		this.no = no;
		this.mainCategory_no = mainCategory_no;
		this.name = name;
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
}