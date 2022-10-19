package com.chaOreum.service.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class HashServiceImp implements HashService {
	
	public String getHash(String password) {
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte bytes[] = md.digest();
			for(int i = 0; i < bytes.length; i++) {
				result.append(
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
				);
			}
		} catch (Exception e) {
			System.out.println("getHash Error : " + e.getMessage());
		}
		
		return result.toString();
	}

}
