<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- header -->
    <header>
        <div id="header">
            <div id="header_empty"></div>
            <a href="/"><img src="../image/logo.png" alt="logo" id="logo"></a>
            
            <c:if test="${empty id}">
	            <div id="account">
	                <a href="/account/logIn">Log In</a>
	                <a href="/account/signUp">Sign Up</a>
	            </div>
            </c:if>
            
            <c:if test="${not empty id}">
	            <div id="user">
	                <div id="userNick">${nickname}</div>
	                <div id="userInfo">
	                    <div onclick="location.href='/account/info?n=${nickname}'">내 정보</div>
	                    <div onclick="location.href='/?n=${nickname}'">My Contents</div>
	                    <div onclick="logOut()">로그아웃</div>
	                    <c:if test="${admin eq true}">
	                    	<div onclick="location.href='/admin'">Administration</div>
	                    </c:if>
	                </div>
	            </div>
	        </c:if>
        </div>
    </header>