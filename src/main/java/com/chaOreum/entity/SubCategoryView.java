package com.chaOreum.entity;

public class SubCategoryView extends SubCategory {
	private String mainCategory_name;
	
	public SubCategoryView() {}

	public SubCategoryView(int no, int mainCategory_no, String name, String mainCategory_name) {
		super(no, mainCategory_no, name);
		this.mainCategory_name = mainCategory_name;
	}

	public String getMainCategory_name() {
		return mainCategory_name;
	}

	public void setMainCategory_name(String mainCategory_name) {
		this.mainCategory_name = mainCategory_name;
	}
}