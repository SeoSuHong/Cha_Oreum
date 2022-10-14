package com.chaOreum.entity;

import java.util.Date;

public class Post {
	private int no;
	private String member_id;
	private int subCategory_no;
	private String title;
	private String contents;
	private Date regDate;
	private String fileName;
	private String fileSize;
	private int view;
	
	public Post() {}

	public Post(int no, String member_id, int subCategory_no, String title, String contents, Date regDate,
			String fileName, String fileSize, int view) {
		this.no = no;
		this.member_id = member_id;
		this.subCategory_no = subCategory_no;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.view = view;
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

	public int getSubCategory_no() {
		return subCategory_no;
	}

	public void setSubCategory_no(int subCategory_no) {
		this.subCategory_no = subCategory_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "Post [no=" + no + ", member_id=" + member_id + ", subCategory_no=" + subCategory_no
				+ ", title=" + title + ", contents=" + contents + ", regDate=" + regDate + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", view=" + view + "]";
	}
}