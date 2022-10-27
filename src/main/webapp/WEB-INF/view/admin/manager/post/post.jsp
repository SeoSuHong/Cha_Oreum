<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <main>
		<h1 id="category">게시글 관리</h1>
		<div id="search_wrap">
			<div></div>
			<div id="search">
	            <select id="field">
	                <option value="title">제목</option>
	                <option value="category">카테고리</option>
	                <option value="id">작성자</option>
	            </select>
	            <div id="keyword_wrap">
	                <input id="keyword">
	                <img id="search_btn" src="/image/search_btn.png" alt="검색" onclick="search()">
	            </div>
	        </div>
	    </div>
	    <div id="total">Total : ${post_cnt}</div>
		<div id="post_wrap">
			<table id="postTbl">
				<tr>
					<th style="width: 40px;">No.</th>
					<th style="width: 100px;">ID</th>
					<th style="width: 160px;">카테고리</th>
					<th>제목</th>
					<th style="width: 120px;">작성일</th>
					<th style="width: 90px;"></th>
				</tr>
				<c:forEach var="p" items="${list}">
					<tr class="postTr">
						<th>${p.no}</th>
						<th>${p.member_id}</th>
						<th>${p.subCategory}</th>
						<td class="title"><a href="detail?no=${p.no}">${p.title}</a></td>
						<th><fmt:formatDate value="${p.regDate}" pattern="yyyy-MM-dd" /></th>
						<th id="postBtn">
							<input type="button" class="deleteBtn" value="삭제" onclick="deletePost(${p.no})">
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
			<input type="hidden" name="t" value="${t}">
			<input type="hidden" name="c" value="${c}">
			<input type="hidden" name="i" value="${i}">
			<input type="hidden" name="p" value="${p}">
		</form>
	</main>