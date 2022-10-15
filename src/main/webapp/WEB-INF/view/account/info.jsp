<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- main -->
    <main id="myInfo_main">
        <div id="myInfo_box">
            <p id="myInfo">회원정보</p>
            <div id="myInfo_id" class="myInfo_inputbox">
                <div class="info">
                    <span class="info_sp">아이디</span>
                </div>
                <div class="myInfo_info_to">
                    <div class="info_box">
                        ${getMemberInfo.id }
                    </div>
                    <form action="/account/secession" name="secession" method="POST">
                    	<input type="hidden" id="id" name="id" value="${getMemberInfo.id }">
                    	<input type="hidden" id="nickname" name="nickname" value="${getMemberInfo.nickname }">
                    </form>
                </div>
            </div>
            <div id="myInfo_nickname" class="myInfo_inputbox">
                <div class="info">
                    <span class="info_sp">닉네임</span>
                </div>
                <div class="myInfo_info_to">
                    <div class="info_box">
                        ${getMemberInfo.nickname }
                    </div>
                </div>
            </div>
            <div id="myInfo_email" class="myInfo_inputbox">
                <div class="info">
                    <span class="info_sp">이메일</span>
                </div>
                <div class="myInfo_info_email">
                    <div class="info_box">
                        ${getMemberInfo.email }
                    </div>
                </div>
            </div>
            <button id="myInfo_btn" onclick="location.href='infoReg'">
                <span id="myInfo_sp">정보 수정</span>
            </button>
            <input type="button" id="member_secession" value="회원 탈퇴" onclick="secession_fn();">
        </div>
    </main>