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
	                        	<div><a download href="/static/post_attachments/${fileName}" class="fileName">${fileName}</a> | 
	                        	<span class="fileSize"><fmt:formatNumber value="${fileSize[st.index] / 1024}" pattern=".00" />KB</span></div>
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
                    <img src="/image/comment.png" id="comment_img"><div id="comment_btn">댓글 쓰기</div>
                </div>
            </div>

            <!-- comment -->
            <div>
            	<c:if test="${not empty comments}">
	                <div id="comments">
	                	<c:forEach var="comment" items="${comments}">
		                    <div class="mainComment">
		                        <div class="nickname">${comment.member_nickname}</div>
		                        <c:if test="${comment.comment_secret eq false}">
	                            	<div class="comment">${comment.contents}</div>
	                            </c:if>
	                            <c:if test="${(comment.comment_secret eq true) && (nickname eq comment.member_nickname || nickname eq post.nickname)}">
	                            	<div class="comment">${comment.contents}</div>
	                            </c:if>
	                            <c:if test="${(comment.comment_secret eq true) && (nickname ne comment.member_nickname) && (nickname ne post.nickname)}">
	                            	<div class="comment">비밀 댓글 입니다.</div>
	                            </c:if>
		                        <div class="commRegDate"><span><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm" /></span><span class="reply_btn">답글 쓰기</span><c:if test="${nickname eq comment.member_nickname}"><span class="comment_delete" onclick="deleteComment(${comment.no})">삭제</span></c:if></div>
		                    </div>
		                    <div class="reply">
	                            <div>
	                                <textarea name="reply" id="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
	                                <div class="reply_btn_wrap">
	                                	<label>
	                                		<input type="checkbox" class="reply_secret"><span id="reply">비밀댓글</span>
	                                	</label>
	                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(this, ${comment.no}, '${nickname}')">
	                                </div>
	                            </div>
		                    </div>
			                <c:forEach var="reply" items="${replies}">
			                    <c:if test="${comment.no eq reply.comment_no}">
				                    <div>
				                        <div class="subComment">
				                            <div class="nickname">${reply.member_nickname}</div>
				                            <c:if test="${reply.reply_secret eq false}">
				                            	<div class="comment">${reply.contents}</div>
				                            </c:if>
				                            <c:if test="${(reply.reply_secret eq true) && (nickname eq reply.member_nickname || nickname eq post.nickname)}">
				                            	<div class="comment">${reply.contents}</div>
				                            </c:if>
				                            <c:if test="${(reply.reply_secret eq true) && (nickname ne reply.member_nickname) && (nickname ne post.nickname)}">
				                            	<div class="comment">비밀 댓글 입니다.</div>
				                            </c:if>
				                            
				                            <div class="commRegDate"><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm" /><c:if test="${nickname eq comment.member_nickname}"><span class="reply_delete" onclick="deleteReply(${reply.no})">삭제</span></c:if></div>
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
                            <input type="button" id="comment_send" value="입력" onclick="sendComment(${post.no}, '${nickname}')">
                        </div>
                    </div>
                </div>
            </div>

            <!-- 수정, 삭제 -->
			<c:if test="${nickname eq post.nickname}">
	            <div id="update_wrap">
                    <input type="button" id="update" value="수 정" onclick="location.href='/board/contents/edit?no=${post.no}'">
                    <input type="button" id="delete" value="삭 제" onclick="delete_post(${post.no})">
	            </div>
	        </c:if>

        </main>