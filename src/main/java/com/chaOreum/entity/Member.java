package com.chaOreum.entity;

import java.sql.Date;

public class Member {
	private String id;
	private String nickname;
	private String password;
	private String email;
	private String role;
	private Date joindate;
	
	public Member() {}

	public Member(String id, String nickname, String password, String email, String role, Date joindate) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.role = role;
		this.joindate = joindate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Date getjoindate() {
		return joindate;
	}
	
	public void setjoindate(Date joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", role="
				+ role + ", joindate=" + joindate + "]";
	}

	
}