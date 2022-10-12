package com.chaOreum.service.account;

import com.chaOreum.entity.Member;

public interface MemberService {
	
	// 로그인
	public Member get(String id, String password);
	
	//아이디 중복확인
	public int id_check(String id);
	
	//닉네임 중복확인
	public int nickname_check(String nickname);
	
	//회원가입
	public boolean signup(String id, String nickname, String password, String email);
	
	//아이디 찾기
	public Member findId(String email);
	
	//이메일 중복확인
	public int email_check(String email);
}