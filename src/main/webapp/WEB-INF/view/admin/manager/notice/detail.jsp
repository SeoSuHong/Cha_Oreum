<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<main>
        
            <div>
                <div id="information">
                    <span id="category">공지사항</span>
                    <span id="regDate"><fmt:formatDate value="${notice.regDate}" pattern="yyy-MM-dd"/></span>
                </div>
                <div id="nickname">${notice.admin_nickname}</div>
                <div id="title">${notice.title}</div>
                <div id="contents">${notice.contents}</div>
            </div>

            <!-- comment -->
            <div>
            	<c:if test="${not empty comments}">
	                <div id="comments">
	                
	                	<c:forEach var="comment" items="${comments}">
		                    <div class="mainComment">
		                        <div class="nickname">${comment.member_nickname}</div>
	                            <div class="comment">${comment.contents}</div>
		                        <div class="commRegDate">
			                        <span><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm" /></span>
			                        <span class="reply_btn">답글 쓰기</span>
			                        <span class="comment_delete" onclick="deleteComment(${comment.no})">삭제</span>
		                        </div>
		                    
		                    </div>
		                    
		                    <div class="reply">
	                            <div>
	                                <textarea name="reply" id="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
	                                <div class="reply_btn_wrap">
	                                	<label>
	                                		<input type="checkbox" class="reply_secret"><span id="reply">비밀댓글</span>
	                                	</label>
	                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(this, ${notice.no}, ${comment.no}, '${nickname}')">
	                                </div>
	                            </div>
		                    </div>
		                    
			                <c:forEach var="reply" items="${replies}">
			                
			                    <c:if test="${comment.no eq reply.comment_no}">
				                    <div>
				                        <div class="subComment">
				                            <div class="nickname">${reply.member_nickname}</div>
				                            <div class="comment">${reply.contents}</div>
				                            <div class="commRegDate">
					                            <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm" />
					                     	    <span class="reply_delete" onclick="deleteReply(${reply.no})">삭제</span>
				                            </div>
				                        </div>
				                    </div>
					            </c:if>
			                </c:forEach>
		                </c:forEach>
		            </div>
		        </c:if>

                <div id="writeComment">
                	<c:if test="${not empty nickname}">
                    	<div id="comment_nick">${nickname}</div>
                    </c:if>
                    <c:if test="${empty nickname}">
                    	<div id="comment_nick">Guest</div>
                    </c:if>
                    <div id="comment_wrap">
                        <textarea name="comment" id="comment_txt" cols="30" rows="10" placeholder="댓글을 입력해 주세요."></textarea><hr>
                        <div id="comment_btn_wrap">
                        	<label>
                          		<input type="checkbox" id="comment_secret"><span id="comment">비밀댓글</span>
                          	</label>
                            <input type="button" id="comment_send" value="입력" onclick="sendComment(${notice.no}, '${nickname}')">
                        </div>
                    </div>
                </div>
            </div>

            <!-- 수정, 삭제 -->
            <div id="update_wrap">
                <input type="button" id="update" value="수 정" onclick="location.href='edit?no=${notice.no}'">
                <input type="button" id="delete" value="삭 제" onclick="delete_notice(${notice.no})">
            </div>

        </main>