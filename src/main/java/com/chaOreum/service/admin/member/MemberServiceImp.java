package com.chaOreum.service.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.admin.MemberDao;
import com.chaOreum.entity.Member;

@Service("adminMemberService")
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Member> getMemberList(String nid, String email, String nickname, String id, int page) {
		return memberDao.getMemberList(nid, email, nickname, id, page);
	}

	@Override
	public boolean deleteMember(String id) {
		return memberDao.deleteMember(id);
	}

	@Override
	public boolean upgradeMember(String id, String role) {
		return memberDao.upgradeMember(id, role);
	}

	@Override
	public int getEndPage(String nid, String email, String nickname, String id) {
		return memberDao.getEndPage(nid, email, nickname, id);
	}

}
