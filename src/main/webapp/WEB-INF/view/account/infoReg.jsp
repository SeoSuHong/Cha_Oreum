<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!-- main -->
    <main id="infoReg_main">
        <div id="infoReg_box">
            <p id="infoReg">회원정보 수정</p>
            <form action="/account/infoReg" method="post" name="infoReg_frm">
                <div id="infoReg_id" class="infoReg_inputbox">
                    <div class="info">
                        <span class="info_sp">아이디</span>
                    </div>
                    <div class="infoReg_info" id="infoRegId">
                        &nbsp;<span>${getMemberInfo.id }</span>
                    </div>
                </div>
                <div id="infoReg_password" class="infoReg_inputbox">
                    <div class="info">
                        <span class="info_sp">변경할 비밀번호</span>
                    </div>
                    <div class="infoReg_info">
                        <input type="password" class="infoReg_input" id="input_password" name="password" value="${getMemberInfo.password }">
                    </div>
                </div>
                <div id="infoReg_password_check" class="infoReg_inputbox">
                    <div class="info">
                        <span class="info_sp">비밀번호 확인</span>
                    </div>
                    <div class="infoReg_info">
                        <input type="password" class="infoReg_input" id="input_password_check" name="password_check" value="${getMemberInfo.password }">
                    </div>
                </div>
                <div id="infoReg_nickname" class="infoReg_inputbox">
                    <div class="info">
                        <span class="info_sp">닉네임</span>
                    </div>
                    <div class="infoReg_info_to">
                        <input type="text" class="infoReg_input_to" id="input_nickname" name="nickname" value="${getMemberInfo.nickname }">
                    </div>
                    <input type="button" class="duplication_check" id="nickname_check" onclick="nickname_check_f();" value="중복확인">
                </div>
                <div id="infoReg_email" class="infoReg_inputbox">
                    <div class="info">
                        <span class="info_sp">이메일</span>
                    </div>
                    <div class="infoReg_info_email">
                    	<c:forTokens var="email" items="${getMemberInfo.email }" delims="@" begin="0" end="0">
                        	<input type="text" class="infoReg_input_email" id="input_email_front" name="email_front" value="${email }">
                        </c:forTokens>
                    </div>
                    <div id="email">
                        <span id="email_sp">@</span>
                    </div>
                    <div class="infoReg_info_email">
                    	<c:forTokens var="email" items="${getMemberInfo.email }" delims="@" begin="1" end="1">
                        	<input type="text" class="infoReg_input_email" id="input_email_back" name="email_back" value="${email }">
                        </c:forTokens>
                    </div>
                </div>
                <input type="hidden" id="hidden_nickname" value="${getMemberInfo.nickname}">
                <input type="hidden" id="hidden_email" value="${getMemberInfo.email}">
                <input type="hidden" name="id" value="${getMemberInfo.id}">
            </form>
            <button id="infoReg_btn" onclick="infoReg_check()">
                <span id="infoReg_sp">정보 수정</span>
            </button>
        </div>
    </main>