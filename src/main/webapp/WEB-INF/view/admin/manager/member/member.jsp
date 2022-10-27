<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<main>
	<h1 id="category">사용자 관리</h1>
	<div id="search_wrap">
		<div></div>
		<div id="search">
			<select id="field">
				<option value="id">ID</option>
				<option value="nickname">닉네임</option>
				<option value="email">이메일</option>
			</select>
			<div id="keyword_wrap">
				<input id="keyword"> 
				<img id="search_btn" src="/image/search_btn.png" alt="검색" onclick="search()">
			</div>
		</div>
	</div>
	<div id="member_wrap">
		<div id="total">Total : ${member_cnt}</div>
		<table id="memberTbl">
			<tr>
				<th>가입 날짜</th>
				<th>ID</th>
				<th>닉네임</th>
				<th>email</th>
				<th>권한</th>
			</tr>
			<c:forEach var="m" items="${MemberList}">
				<tr class="memberTr">
					<th>${m.joindate}</th>
					<th>${m.id}</th>
					<th>${m.nickname}</th>
					<th>${m.email}</th>
					<th>${m.role}</th>
					<th id="memberBtn"><input type="button" value="추방"
						onclick="deleteMember('${m.id}')"> <input type="button"
						value="권한 변경" onclick="upgradeMember('${m.id}', '${m.role}')">
					</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- 페이징 -->
    <div id="pages">
    	<c:if test="${p > page.block_per_page}">
     	<span id="firstPage" class="movePage">First</span>
     	<span id="prevPage" class="movePage" onclick="movePrevPage(${page.block_firstPage})">Prev</span>
    	</c:if>
    	
    	<c:forEach var="pageNo" begin="${page.block_firstPage}" end="${page.block_endPage}">
    		<c:if test="${pageNo <= page.endPage}">
      		<c:if test="${p eq pageNo}">
      			<span class="myPage">${pageNo}</span>
      		</c:if>
      		<c:if test="${p ne pageNo}">
       			<span class="page">${pageNo}</span>
      		</c:if>
     		</c:if>
    	</c:forEach>
    	
    	<c:if test="${p < page.endBlock_firstPage}">
     	<span id="nextPage" class="movePage" onclick="moveNextPage(${page.block_firstPage})">Next</span>
     	<span id="lastPage" class="movePage" onclick="moveLastPage(${page.endPage})">Last</span>
     	</c:if>
    </div>
	
	<form name="postForm" action="view" method="get">
			<input type="hidden" name="e" value="${e}">
			<input type="hidden" name="n" value="${n}">
			<input type="hidden" name="i" value="${i}">
			<input type="hidden" name="p" value="${p}">
		</form>
</main>