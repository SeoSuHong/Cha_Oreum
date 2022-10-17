package com.chaOreum.dao.account;

import com.chaOreum.entity.Member;

public interface MemberDao {

	// 로그인
	public Member get(String id, String password);

	//아이디 중복확인
	public int id_check(String id);
	
	//닉네임 중복확인
	public int nickname_check(String nickname);
	
	//회원가입
	public boolean signup(String id, String nickname, String password, String email);
	
	//아이디 찾기
	public Member findId(String email);
	
	//이메일 중복확인
	public int email_check(String email);
	
	//info page get member info
	public Member getInfo(String id);
	
	//infoReg page update info
	public boolean updateInfo(String id, String nickname, String password, String email);
	
	//회원탈퇴
	public boolean secession(String id, String nickname);
	
	//비밀번호 찾기_변경
	public boolean findPw(String id, String password);
	
	//비밀번호 찾기 이메일 일치여부 확인
	public String id_email(String id);


}
