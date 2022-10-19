package com.chaOreum.entity;

public class View {
	private String ip;
	private int post_no;
	
	public View() {}
	
	public View(String ip, int post_no) {
		super();
		this.ip = ip;
		this.post_no = post_no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
}