package com.chaOreum.service.account;

import com.chaOreum.entity.Member;

public interface MemberService {
	
	// 로그인
	public Member get(String id, String password);
	
	//아이디 중복검사
	public int id_check(String id);
}