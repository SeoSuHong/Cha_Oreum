package com.chaOreum.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.account.MemberDao;
import com.chaOreum.entity.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member get(String id, String password) {
		return memberDao.get(id, password);
	}

	@Override
	public int id_check(String id) {
		int result = memberDao.id_check(id);
		return result;
	}
}