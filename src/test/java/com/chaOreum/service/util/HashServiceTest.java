package com.chaOreum.service.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashServiceTest {
	
	private HashService hashService = new HashServiceImp();

	@Test
	void 해시코드() {
		String password = "suhong123123";
		
		System.out.println(hashService.getHash(password));
	}

}
