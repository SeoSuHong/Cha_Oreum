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
	                <div>
                    	<div id="hart">🤍</div><div id="like">좋아요</div>
                    </div>
                </c:if>
                <c:if test="${like_isChecked == 1}">
                	<div>
                    	<div id="hart">❤️</div><div id="like">좋아요</div>
                    </div>
                </c:if>
                <div onclick="comment_focus()">
                    <img src="../image/comment.png" id="comment_img"><div id="comment_btn">댓글 쓰기</div>
                </div>
            </div>

            <!-- comment -->
            <div>
                <div id="comments">
                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>

                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>

                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>
                </div>
                <div id="writeComment">
                    <form name="commentForm" action="" method="post">
                        <div id="comment_nick">Dev_Hong</div>
                        <div id="comment_wrap">
                            <textarea name="comment" id="comment_txt" cols="30" rows="10"></textarea><hr>
                            <div id="comment_btn_wrap">
                                <input type="button" id="comment_send" value="입력">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- 수정, 삭제 -->
			<c:if test="${nickname eq post.nickname}">
	            <div id="update_wrap">
	                <form name="updateForm" method="post">
	                    <input type="button" name="" id="update" value="수 정" onclick="location.href='/contents/edit'">
	                    <input type="button" name="" id="delete" value="삭 제">
	                </form>
	            </div>
	        </c:if>

        </main>