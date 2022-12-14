package com.chaOreum.dao.admin;

import java.util.List;

import com.chaOreum.entity.Member;

public interface MemberDao {
	
	//회원 정보 전부 가져오기
	List<Member> getMemberList(String nid, String email, String nickname, String id, int page);

	//회원 추방하기
	boolean deleteMember(String id);
	
	//회원 권한 변경
	boolean upgradeMember(String id, String role);

	//회원 총 갯수
	int getEndPage(String nid, String email, String nickname, String id);

}
