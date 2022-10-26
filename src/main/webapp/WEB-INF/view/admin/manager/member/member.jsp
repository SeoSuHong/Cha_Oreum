<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <main>
		<h1 id="category">사용자 관리</h1>
		<div id="member_wrap">
			<div id="total">Total : ${fn:length(list)}</div>
			<table id="memberTbl">
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>닉네임</th>
					<th></th>
				</tr>
				<c:forEach var="m" items="${list}">
					<tr class="memberTr">
						<th>${m.no}</th>
						<th>${m.id}</th>
						<th>${m.nickname}</th>
						<th id="memberBtn">
							<input type="button" value="삭제" onclick="deleteMember(${m.no})">
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>