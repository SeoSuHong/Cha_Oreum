<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<main id="findpwd_main">
        <div id="findpwd_box">
            <p id="findpwd">비밀번호 찾기</p>
            <form action="" method="post" name="findpwd_frm">
                <div id="findpwd_id" class="findpwd_inputbox">
                    <div class="info">
                        <span class="info_sp">아이디</span>
                    </div>
                    <div class="findpwd_info">
                        <input type="text" class="findpwd_input" id="input_id" name="findpwd_id">
                    </div>
                </div>
                <div id="findpwd_email" class="findpwd_inputbox">
                    <div class="info">
                        <span class="info_sp">이메일</span>
                    </div>
                    <div class="findpwd_info_email">
                        <input type="text" class="findpwd_input_email" id="email_front" name="findpwd_email">
                    </div>
                    <div id="email">
                        <span id="email_sp">@</span>
                    </div>
                    <div class="findpwd_info_email">
                        <input type="text" class="findpwd_input_email" id="email_back" name="findpwd_email_back">
                    </div>
                </div>
                <div id="findpwd_certification" class="findpwd_inputbox">
                    <div class="info">
                        <span class="info_sp">인증번호</span>
                    </div>
                    <div class="findpwd_info_to">
                        <input type="text" class="findpwd_input_to" id="input_certification" name="findpwd_certification">
                    </div>
                    <button class="certification_btn" id="certification" onclick="">
                        <span class="certification_sp">인증번호 발송</span>
                    </button>
                </div>
                <div id="findpwd_password" class="findpwd_inputbox">
                    <div class="info">
                        <span class="info_sp">새로운 비밀번호</span>
                    </div>
                    <div class="findpwd_info">
                        <input type="password" class="findpwd_input" id="input_password" name="findpwd_password">
                    </div>
                </div>
                <div id="findpwd_password_check" class="findpwd_inputbox">
                    <div class="info">
                        <span class="info_sp">비밀번호 확인</span>
                    </div>
                    <div class="findpwd_info">
                        <input type="password" class="findpwd_input" id="input_password_check" name="findpwd_password_check">
                    </div>
                </div>
            </form>
            <button id="findpwd_btn" onclick="findid_check()"><span id="findpwd_sp">비밀번호 변경</span></button>
            &nbsp;&nbsp;&nbsp;
            <a href="/account/logIn" class="uri">로그인</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/account/findId" class="uri">아이디 찾기</a>
        </div>
    </main>