<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<main>
        
            <div>
                <div id="information">
                    <span id="category"><span>${post.mainCategory}</span> - <span>${post.subCategory}</span></span>
                    <span id="regDate"><fmt:formatDate value="${post.regDate}" pattern="yyy-MM-dd"/></span>
                </div>
                <div id="nickname">${post.nickname}</div>
                <div id="title">${post.title}</div>
                <c:if test="${not empty post.fileName}">
	                <div id="files">
	                    <div id="file">첨부 파일</div>
	                    <div class="file">
	                    	<c:set var="fileSize" value="${fn:split(post.fileSize, '/')}"/>
	                    	<c:forTokens var="fileName" items="${post.fileName}" delims="/" varStatus="st">
	                        	<div><a download href="/post_attachments/${fileName}" class="fileName">${fileName}</a> | 
	                        	<span class="fileSize"><fmt:formatNumber value="${fileSize[st.index] / 1024}" pattern=".00" />KB</span></div>
	                        </c:forTokens>
	                    </div>
	                </div>
	            </c:if>
                <div id="contents">${post.contents}</div>
            </div>

            <!-- comment -->
            <div>
            	<c:if test="${not empty comments}">
	                <div id="comments">
	                	<c:forEach var="comment" items="${comments}">
		                    <div class="mainComment">
		                        <div class="nickname">${comment.member_nickname}</div>
	                            <div class="comment">${comment.contents}</div>
		                        <div class="commRegDate"><span><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm" /></span><span class="comment_delete" onclick="deleteComment(${comment.no})">삭제</span></div>
		                    </div>
			                <c:forEach var="reply" items="${replies}">
			                    <c:if test="${comment.no eq reply.comment_no}">
				                    <div>
				                        <div class="subComment">
				                            <div class="nickname">${reply.member_nickname}</div>
				                            <div class="comment">${reply.contents}</div>
				                            <div class="commRegDate"><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm" /><span class="reply_delete" onclick="deleteReply(${reply.no})">삭제</span></div>
				                        </div>
				                    </div>
					            </c:if>
			                </c:forEach>
		                </c:forEach>
		            </div>
		        </c:if>
            </div>
        </main>