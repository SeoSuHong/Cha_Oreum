<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<main id="loginmain">
        <div id="loginbox">
            <p id="Loginst">Login</p>
            <div id="loginiputbox">
                <div id="login">
                    <form action="/account/logIn" method="post" name="login_frm">
                        <div id="loginid" class="logininput_box">
                            <input type="text" class="logininput" id="input_id" name="id">
                        </div>
                        <div id="loginpassword" class="logininput_box">
                            <input type="password" class="logininput" id="input_password" name="password">
                        </div>
                    </form>
                </div>
                <div>
                    <button id="loginbtn" onclick="login_check()"><span id="lobtn">Login</span></button>
                </div>
            </div>
            <a class="lowst" id="signup" href="/account/signUp">회원가입</a>
            &nbsp;&nbsp;
            <a class="lowst" id="idserch" href="/account/findId">아이디/비밀번호 찾기</a>
        </div>
    </main>