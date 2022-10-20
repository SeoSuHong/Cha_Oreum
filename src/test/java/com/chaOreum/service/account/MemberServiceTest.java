package com.chaOreum.service.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.chaOreum.dao.account.MemberDao;
import com.chaOreum.entity.Member;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberDao memberDao;
	
	@Test
	void 로그인() {
		String id = "suhong";
		String password = "suhong";
		
		Member member = memberDao.get(id, password);
		
		System.out.println(member);
	}

	@Test
	void 메일_인증코드() throws Exception {
		String code = memberService.sendEmail("eksrnsdhkdwk@naver.com");
		
		System.out.println(code);
	}
	
}
