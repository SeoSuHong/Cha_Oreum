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
	public boolean signup(String id, String password, String nickname, String email) {
		boolean result = mapper.signup(id, nickname, password, email);
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

}
