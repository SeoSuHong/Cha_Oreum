<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<main>

                <!-- 검색 기능 -->
                <div id="search_wrap">
                    <div></div>
                    <div id="search">
                        <select id="field">
                            <option value="title">제목</option>
                            <option value="nickname">작성자</option>
                        </select>
                        <div id="keyword_wrap">
                            <input id="keyword">
                            <img id="search_btn" src="../image/search_btn.png" alt="검색" onclick="search()">
                        </div>
                    </div>
                </div>

                <!-- 정렬 기능 -->
                <div id="sort_wrap">
                    <div id="newSort_wrap" style="cursor: pointer;" onclick="sort('new')">
                    	<c:if test="${s eq 'new' || empty s}">
	                        <img src="../image/checkedSort.png">
	                        <span style="color: #38424A;">최신</span>
                        </c:if>
                        <c:if test="${s ne 'new' && not empty s}">
	                        <img src="../image/uncheckedSort.png">
	                        <span style="color: #AEAEAE;">최신</span>
                        </c:if>
                    </div>
                    <div id="hotSort_wrap" style="cursor: pointer;" onclick="sort('hot')">
                    	<c:if test="${s eq 'hot'}">
	                        <img src="../image/checkedSort.png">
	                        <span style="color: #38424A;">인기</span>
	                    </c:if>
	                    <c:if test="${s ne 'hot'}">
	                        <img src="../image/uncheckedSort.png">
	                        <span style="color: #AEAEAE;">인기</span>
	                    </c:if>
                    </div>
                    <div id="lookSort_wrap" style="cursor: pointer;" onclick="sort('look')">
                    	<c:if test="${s eq 'look'}">
	                        <img src="../image/checkedSort.png">
	                        <span style="color: #38424A;">조회</span>
	                    </c:if>
	                    <c:if test="${s ne 'look'}">
	                        <img src="../image/uncheckedSort.png">
	                        <span style="color: #AEAEAE;">조회</span>
	                    </c:if>
                    </div>
	            	<input type="button" id="notice_btn" value="공지사항 숨기기">
                </div>

                <!-- 글 쓰기 -->
                <c:if test="${not empty nickname && nickname eq n}">
	                <div id="reg_wrap">
	                    <a href="/contents/reg" id="reg">글 쓰기</a>
	                </div>
	            </c:if>
	            
	            <!-- 공지사항 -->
	            <c:if test="${empty p || p eq 1}">
		            <div id="notice">
		            	<div id="notice_txt">※ 공지사항 ※</div>
		            	<table id="noticeList">
		            		<tr>
		            			<th id="noticeNo">No.</th>
		            			<th id="noticeTitle">제목</th>
		            			<th id="noticeWriter">작성자</th>
		            			<th id="noticeRegDate">작성일</th>
		            		</tr>
		            		<tr>
		            			<td style="text-align: center;">1</td>
		            			<td style="padding-left: 5px;"><a href="">비밀 댓글(추후 업데이트 예정)</a></td>
		            			<td style="text-align: center;">관리자</td>
		            			<td style="text-align: center;">2022-10-20</td>
		            		</tr>
		            		<tr>
		            			<td style="text-align: center;">2</td>
		            			<td style="padding-left: 5px;"><a href="">태희는 바보인 듯 하다.</a></td>
		            			<td style="text-align: center;">관리자</td>
		            			<td style="text-align: center;">2022-10-20</td>
		            		</tr>
		            		<tr>
		            			<td style="text-align: center;">3</td>
		            			<td style="padding-left: 5px;"><a href="">그런 듯 한게 아니라 바보이다.</a></td>
		            			<td style="text-align: center;">관리자</td>
		            			<td style="text-align: center;">2022-10-20</td>
		            		</tr>
		            		<tr>
		            			<td style="text-align: center;">4</td>
		            			<td style="padding-left: 5px;"><a href="">Cha Oreum 상반기 이벤트</a></td>
		            			<td style="text-align: center;">관리자</td>
		            			<td style="text-align: center;">2022-10-20</td>
		            		</tr>
		            		<tr>
		            			<td style="text-align: center;">5</td>
		            			<td style="padding-left: 5px;"><a href="">Develop Study 모집 카테고리 (추후 업데이트 예정)</a></td>
		            			<td style="text-align: center;">관리자</td>
		            			<td style="text-align: center;">2022-10-20</td>
		            		</tr>
		            	</table>
		            </div>
				</c:if>
				
                <!-- 컨텐츠 -->
                <div id="contents">
                	
					<c:forEach var="post" items="${list}">
	                    <div class="content">
	                        <div class="information">
	                            <div class="info">
	                                <span>${post.nickname}</span>
	                                <span>❤️${post.hot}</span>
	                                <span><img src="../image/look.png"> ${post.view}</span>
	                                <span class="cate">${post.mainCategory} - ${post.subCategory}</span>
	                            </div>
	                            <div class="reg">
	                                <span><fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd"/></span>
	                            </div>
	                        </div>
	
	                        <div class="title"><a href="/contents/detail?no=${post.no}">${post.title}</a></div>
	                        <div class="cont">${post.contents}</div>
	                    </div>
                    </c:forEach>
                    
                </div>
                <!-- 맨 위로 -->
                <c:if test="${not empty list}">
	                <div id="screenUp_wrap">
	                    <div id="screenUp" onclick="scrollToTop(); return false;">맨 위로</div>
	                </div>
	            </c:if>

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

            </main>