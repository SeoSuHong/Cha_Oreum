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

}
