<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <main>
		<h1 id="category">카테고리 관리</h1>
		<div id="category_wrap">
			<div id="mainTitle_txt">Main Category<img class="plus" alt="추가" src="/image/plus.png" onclick="appendMain()"></div>
			<div id="total">Total : ${fn:length(mainList)}</div>
			<table class="categoryTbl" id="mainCategory">
				<tr>
					<th style="width: 50px;">No.</th>
					<th>이름</th>
					<th style="width: 100px;">게시글 수</th>
					<th></th>
				</tr>
				<c:forEach var="mc" items="${mainList}">
					<tr class="categoryTr">
						<th>${mc.no}</th>
						<th><input type="button" class="name" value="${mc.name}"></th>
						<th>${mc.post_cnt}</th>
						<th id="categoryBtn">
							<input type="button" class="btn" value="수정" onclick="editMain(this, ${mc.no})">
							<input type="button" class="btn" value="삭제" onclick="deleteMain(${mc.no})">
						</th>
					</tr>
				</c:forEach>
				
			</table>
			
			<div id="subTitle_txt">Sub Category<img class="plus" alt="추가" src="/image/plus.png" onclick="appendSub()"></div>
			<div id="total">Total : ${fn:length(subList)}</div>
			<table class="categoryTbl" id="subCategory">
				<tr>
					<th style="width: 50px;">No.</th>
					<th style="width: 100px;">Main No.</th>
					<th>이름</th>
					<th style="width: 100px;">게시글 수</th>
					<th></th>
				</tr>
				<c:forEach var="sc" items="${subList}">
					<tr class="categoryTr">
						<th>${sc.no}</th>
						<th><input type="button" class="mainCategory_no" value="${sc.mainCategory_no}"></th>
						<th><input type="button" class="name" value="${sc.name}"></th>
						<th>${sc.post_cnt}</th>
						<th id="categoryBtn">
							<input type="button" class="btn" value="수정" onclick="editSub(this, ${sc.no})">
							<input type="button" class="btn" value="삭제" onclick="deleteSub(${sc.no})">
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>