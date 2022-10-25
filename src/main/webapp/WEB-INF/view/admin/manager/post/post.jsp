<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <main>
		<h1 id="category">게시글 관리</h1>
		<div id="post_wrap">
			<div id="total">Total : ${fn:length(list)}</div>
			<table id="postTbl">
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>닉네임</th>
					<th>메인</th>
					<th>서브</th>
					<th>제목</th>
					<th>작성일</th>
					<th></th>
				</tr>
				<c:forEach var="p" items="${list}">
					<tr class="postTr">
						<th>${p.no}</th>
						<th>${p.member_id}</th>
						<th>${p.nickname}</th>
						<th>${p.mainCategory}</th>
						<th>${p.subCategory}</th>
						<td><a href="detail?no=${p.no}">${p.title}</a></td>
						<th><fmt:formatDate value="${p.regDate}" pattern="yyyy-MM-dd" /></th>
						<th id="postBtn">
							<input type="button" value="삭제" onclick="noticeDelete(${p.no})">
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>