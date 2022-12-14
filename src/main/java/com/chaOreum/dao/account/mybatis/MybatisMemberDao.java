package com.chaOreum.dao.account.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.account.MemberDao;
import com.chaOreum.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao {
	
	private MemberDao mapper;
	
	@Autowired
	public MybatisMemberDao(SqlSession session) {
		mapper = session.getMapper(MemberDao.class);
	}
	
	@Override
	public Member get(String id, String password) {
		return mapper.get(id, password);
	}

	@Override
	public int id_check(String id) {
		int result = mapper.id_check(id);
		return result;
	}

	@Override
	public int nickname_check(String nickname) {
		int result = mapper.nickname_check(nickname);
		return result;
	}

	@Override
	public boolean signup(String id, String password, String nickname, String email, String role) {
		boolean result = mapper.signup(id, nickname, password, email, role);
		return result;
		
	}

	@Override
	public Member findId(String email) {
		return mapper.findId(email);
	}

	@Override
	public int email_check(String email) {
		int result = mapper.email_check(email);
		return result;
	}

	@Override
	public Member getInfo(String id) {
		Member result = mapper.getInfo(id);
		return result;
	}

	@Override
	public boolean updateInfo(String id, String nickname, String password, String email) {
		boolean result = mapper.updateInfo(id, nickname, password, email);
		return result;
	}

	@Override
	public boolean secession(String id, String nickname) {
		boolean result = mapper.secession(id, nickname);
		return result;
	}

	@Override
	public boolean findPw(String id, String password) {
		boolean result = mapper.findPw(id, password);
		return result;
	}

	@Override
	public String id_email(String id) {
		String result = mapper.id_email(id);
		return result;
	}

}
