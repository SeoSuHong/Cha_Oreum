package com.chaOreum.dao.account;

import com.chaOreum.entity.Member;

public interface MemberDao {

	// 로그인
	public Member get(String id, String password);
	
}
