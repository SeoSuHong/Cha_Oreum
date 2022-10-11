<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<main id="findid_main">
        <div id="findid_box">
            <p id="findid">아이디 찾기</p>
            <form action="" name="findid_frm" method="post">
                <div id="input_findid_box">
                    <div id="email_box">
                        <span id="find_email">이메일</span>
                    </div>
                    <input type="text" class="input_email" id="email_front" name="email_front">
                    <div id="email_sp_box">
                        <span id="email_sp">@</span>
                    </div>
                    <input type="text" class="input_email" id="email_back" name="email_back">
                </div>
            </form>
            <div id="btn_box">
                <button id="findid_btn" onclick="findid_check()">
                    <span id="findid_sp">아이디 찾기</span>
                </button>
                &nbsp;&nbsp;&nbsp;
                <a href="/account/logIn" id="login_uri">로그인</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/account/findPw" id="find_pwd_uri">비밀번호 찾기</a>
            </div>
        </div>
    </main>