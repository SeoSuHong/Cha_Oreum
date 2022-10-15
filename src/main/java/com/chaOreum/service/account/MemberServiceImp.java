package com.chaOreum.service.account;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaOreum.dao.account.MemberDao;
import com.chaOreum.entity.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member get(String id, String password) {
		return memberDao.get(id, password);
	}

	@Override
	public int id_check(String id) {
		int result = memberDao.id_check(id);
		return result;
	}

	@Override
	public int nickname_check(String nickname) {
		int result = memberDao.nickname_check(nickname);
		return result;
	}

	@Override
	public boolean signup(String id, String password, String nickname, String email) {
		boolean result = memberDao.signup(id, nickname, password, email);
		return result;
	}

	@Override
	public Member findId(String email) {
		Member result = memberDao.findId(email);
		return result;
	}

	@Override
	public int email_check(String email) {
		int result = memberDao.email_check(email);
		return result;
	}

	@Override
	public Member getInfo(String id) {
		Member result = memberDao.getInfo(id);
		return result;
	}

	@Override
	public boolean updateInfo(String id, String nickname, String password, String email) {
		boolean result = memberDao.updateInfo(id, nickname, password, email);
		return result;
	}

	@Override
	public boolean secession(String id, String nickname) {
		boolean result = memberDao.secession(id, nickname);
		return result;
	}

	@Override
	public String sendEmail(String to) throws Exception {
		String user = "suhong58@gmail.com";
		String password = "xpqvtlgcvooegxwc";
		
		String result = "fail";
//		Properties prop = new Properties();
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.port", "465");
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.ssl.enable", "true");
//		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Properties prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		// 인증코드 생성
		Random ran = new Random();
		
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < 6; i++) {
			if(ran.nextBoolean()) {
				buffer.append((int)(ran.nextInt(10)));
			} else {
				buffer.append((char)((int)(Math.random() * 26) + 65));
			}
		}
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user));
		
		// 수신자 메일주소
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		// Subject
		message.setSubject("Cha Oreum :: 회원정보 인증코드");  // 메일 제목
		
		// Text
		message.setText("회원정보 변경 인증코드는 [" + buffer + "] 입니다.");  // 메일 내용
		
		// send the message
		Transport.send(message);  // 전송

		return result = buffer.toString();
	}

	@Override
	public boolean findPw(String id, String password) {
		boolean result = memberDao.findPw(id, password);
		return result;
	}

	@Override
	public String id_email(String id) {
		String result = memberDao.id_email(id);
		return result;
	}
}