package com.chaOreum.entity;

import java.util.Date;

public class PostView extends Post {
	private String mainCategory;
	private String subCategory;
	private String nickname;
	private int view;
	private int hot;

	public PostView() {}

	public PostView(String mainCategory, String subCategory, String nickname, int no, String member_id, int subCategory_no, String title, String contents, Date regDate,
			String fileName, String fileSize, int view, int hot) {
		
		super(no, member_id, subCategory_no, title, contents, regDate, fileName, fileSize);
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.nickname = nickname;
		this.view = view;
		this.hot = hot;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return "PostView [mainCategory=" + mainCategory + ", subCategory=" + subCategory + ", nickname=" + nickname + ", " + super.toString() + ", view=" + view + ", hot=" + hot + "]";
	}
}