<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <main>
		<h1 id="category">공지사항 관리</h1>
		<div id="notice_wrap">
			<div id="total">Total : ${fn:length(list)}</div>
			<table id="noticeTbl">
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>닉네임</th>
					<th>제목</th>
					<th>작성일</th>
					<th></th>
				</tr>
				<c:forEach var="n" items="${list}">
					<tr class="noticeTr">
						<th>${n.no}</th>
						<th>${n.admin_id}</th>
						<th>${n.admin_nickname}</th>
						<td><a href="detail?no=${n.no}">${n.title}</a></td>
						<th><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" /></th>
						<th id="noticeBtn">
							<input type="button" value="수정" onclick="location.href='edit?no=${n.no}'">
							<input type="button" value="삭제" onclick="noticeDelete(${n.no})">
						</th>
					</tr>
				</c:forEach>
			</table>
			<div id="edit"><a href="reg">작성</a></div>
		</div>
	</main>