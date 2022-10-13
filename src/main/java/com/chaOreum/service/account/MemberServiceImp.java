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

	@Override
	public int nickname_check(String nickname) {
		int result = memberDao.nickname_check(nickname);
		return result;
	}

	@Override
	public boolean signup(String id, String password, String nickname, String email) {
		boolean result = memberDao.signup(id, nickname, password, email);
		return result;
	}

	@Override
	public Member findId(String email) {
		Member result = memberDao.findId(email);
		return result;
	}

	@Override
	public int email_check(String email) {
		int result = memberDao.email_check(email);
		return result;
	}

	@Override
	public Member getInfo(String id) {
		Member result = memberDao.getInfo(id);
		return result;
	}

	@Override
	public boolean updateInfo(String id, String nickname, String password, String email) {
		boolean result = memberDao.updateInfo(id, nickname, password, email);
		return result;
	}
}