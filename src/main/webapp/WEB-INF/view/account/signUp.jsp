<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- main -->
    <main id="signup_main">
        <div id="signup_box">
            <p id="signup">회원가입</p>
            <form action="" method="post" name="signup_frm">
                <div id="signup_id" class="signup_inputbox">
                    <div class="info">
                        <span class="info_sp">아이디</span>
                    </div>
                    <div class="signup_info_to">
                        <input type="text" class="signup_input_to" id="input_id" name="signup_id">
                    </div>
                    <button class="duplication_check" id="id_check" onclick=""><span class="duplication_sp">중복확인</span></button>
                </div>
                <div id="signup_password" class="signup_inputbox">
                    <div class="info">
                        <span class="info_sp">비밀번호</span>
                    </div>
                    <div class="signup_info">
                        <input type="password" class="signup_input" id="input_password" name="signup_password">
                    </div>
                </div>
                <div id="signup_password_check" class="signup_inputbox">
                    <div class="info">
                        <span class="info_sp">비밀번호 확인</span>
                    </div>
                    <div class="signup_info">
                        <input type="password" class="signup_input" id="input_password_check" name="signup_password_check">
                    </div>
                </div>
                <div id="signup_nickname" class="signup_inputbox">
                    <div class="info">
                        <span class="info_sp">닉네임</span>
                    </div>
                    <div class="signup_info_to">
                        <input type="text" class="signup_input_to" id="input_nickname" name="signup_nickname">
                    </div>
                    <button class="duplication_check" id="nickname_check" onclick=""><span class="duplication_sp">중복확인</span></button>
                </div>
                <div id="signup_email" class="signup_inputbox">
                    <div class="info">
                        <span class="info_sp">이메일</span>
                    </div>
                    <div class="signup_info_email">
                        <input type="text" class="signup_input_email" id="input_email_front" name="input_email_front">
                    </div>
                    <div id="email">
                        <span id="email_sp">@</span>
                    </div>
                    <div class="signup_info_email">
                        <input type="text" class="signup_input_email" id="input_email_back" name="signup_email_back">
                    </div>
                </div>
            </form>
            <button id="signup_btn" onclick="signup_check()">
                <span id="signup_sp">회원가입</span>
            </button>
            &nbsp;&nbsp;&nbsp;
            <a href="/account/findId" id="idserch">아이디/비밀번호 찾기</a>
        </div>
    </main>