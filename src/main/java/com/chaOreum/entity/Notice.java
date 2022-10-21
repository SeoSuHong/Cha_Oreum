package com.chaOreum.entity;

import java.util.Date;

public class Notice {
	private int no;
	private String admin_id;
	private String title;
	private String contents;
	private Date regDate;
	
	public Notice() {}

	public Notice(int no, String admin_id, String title, String contents, Date regDate) {
		super();
		this.no = no;
		this.admin_id = admin_id;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
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

	@Override
	public String toString() {
		return "Notice [no=" + no + ", admin_id=" + admin_id + ", title=" + title + ", contents=" + contents
				+ ", regDate=" + regDate + "]";
	}
}