package com.chaOreum.dao.admin.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaOreum.dao.admin.MemberDao;
import com.chaOreum.entity.Member;

@Repository("adminMemberDao")
public class MybatisMemberDao implements MemberDao {
	
	private MemberDao mapper;
	
	@Autowired
	public MybatisMemberDao(SqlSession session) {
		mapper = session.getMapper(MemberDao.class);
	}
	
	@Override
	public List<Member> getMemberList(String nid, String email, String nickname, String id, int page) {
		return mapper.getMemberList(nid, email, nickname, id, page);
	}

	@Override
	public boolean deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	@Override
	public boolean upgradeMember(String id, String role) {
		return mapper.upgradeMember(id, role);
	}

	@Override
	public int getEndPage(String nid,String email, String nickname, String id) {
		// TODO Auto-generated method stub
		return mapper.getEndPage(nid, email, nickname, id);
	}
	
}
