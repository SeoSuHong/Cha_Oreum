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
	                        	<div><a download href="" class="fileName">${fileName}</a> | 
	                        	<span class="fileSize">${fileSize[st.index]}Byte</span></div>
	                        </c:forTokens>
	                    </div>
	                </div>
	            </c:if>
                <div id="contents">${post.contents}</div>
            </div>

            <div id="guest">
               	<c:if test="${like_isChecked == 0}">
	                <div id="like_wrap" onclick="like(${post.no}, '${id}')">
                    	<div id="hart">🤍</div><div id="like">좋아요</div>
                    </div>
                    <div id="unlike_wrap" style="display: none;" onclick="unlike(${post.no}, '${id}')">
                    	<div id="hart">❤️</div><div id="like">좋아요</div>
                    </div>
                </c:if>
                <c:if test="${like_isChecked == 1}">
                	<div id="unlike_wrap" onclick="unlike(${post.no}, '${id}')">
                    	<div id="hart">❤️</div><div id="like">좋아요</div>
                    </div>
                    <div id="like_wrap" style="display: none;" onclick="like(${post.no}, '${id}')">
                    	<div id="hart">🤍</div><div id="like">좋아요</div>
                    </div>
                </c:if>
                <div onclick="comment_focus()">
                    <img src="../image/comment.png" id="comment_img"><div id="comment_btn">댓글 쓰기</div>
                </div>
            </div>

            <!-- comment -->
            <div>
            	<c:if test="${not empty comments}">
	                <div id="comments">
	                	<c:forEach var="comment" items="${comments}">
		                    <div class="mainComment">
		                        <div class="nickname">${comment.member_nickname}</div>
		                        <div class="comment">${comment.contents}</div>
		                        <div class="commRegDate"><span><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm" /></span><span class="reply_btn">답글 쓰기</span></div>
		                    </div>
		                    <div class="reply">
	                            <div>
	                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
	                                <div class="reply_btn_wrap">
	                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(${comment.no}, '${nickname}')">
	                                </div>
	                            </div>
		                    </div>
			                <c:forEach var="reply" items="${replies}">
			                    <c:if test="${comment.no eq reply.comment_no}">
				                    <div>
				                        <div class="subComment">
				                            <div class="nickname">${reply.member_nickname}</div>
				                            <div class="comment">${reply.contents}</div>
				                            <div class="commRegDate"><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm" /></div>
				                        </div>
				                    </div>
					            </c:if>
			                </c:forEach>
		                </c:forEach>
		            </div>
		        </c:if>

                <div id="writeComment">
                    <div id="comment_nick">Dev_Hong</div>
                    <div id="comment_wrap">
                        <textarea name="comment" id="comment_txt" cols="30" rows="10" placeholder="댓글을 입력해 주세요."></textarea><hr>
                        <div id="comment_btn_wrap">
                            <input type="button" id="comment_send" value="입력">
                        </div>
                    </div>
                </div>
            </div>

            <!-- 수정, 삭제 -->
			<c:if test="${nickname eq post.nickname}">
	            <div id="update_wrap">
	                <form name="updateForm" method="post">
	                    <input type="button" id="update" value="수 정" onclick="location.href='/contents/edit?no=${post.no}'">
	                    <input type="button" id="delete" value="삭 제" onclick="">
	                </form>
	            </div>
	        </c:if>

        </main>