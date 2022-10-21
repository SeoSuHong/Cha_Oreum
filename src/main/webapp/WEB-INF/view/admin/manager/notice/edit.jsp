<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<main>
        
            <div>
                <form name="editForm" action="/board/contents/edit" method="post" enctype="multipart/form-data">
                    <div id="regCategory">
                        <div>* Main Category</div>
                        <select name="mainCategory" id="mainCategory" onchange="changeMainCategory()">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <c:forEach var="mc" items="${mainCategories}">
                            	<option value="${mc.no}" <c:if test="${post.mainCategory eq mc.name}">selected</c:if>>${mc.name}</option>
                            </c:forEach>
                        </select>

                        <div>* Sub Category</div>
                        <select name="subCategory" id="subCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                        </select>
                        <input type="hidden" id="prevSubCategory" value="${post.subCategory}">
                    </div>

                    <hr>

                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title" value="${post.title}">
                    </div>

                    <hr>

                    <c:set var="fileSize" value="${fn:split(post.fileSize, '/')}" />
                    <div id="file_wrap">
                    	<c:if test="${not empty post.fileName}">
	                        <div class="txt">첨부 파일</div>
	                        <div id="f">
	                    		<c:forTokens var="fileName" items="${post.fileName}" delims="/" varStatus="st">
		                            <div class="file">
		                            	·<a download href="/static/post_attachments/${fileName}">${fileName}</a><div class="file_delete" onclick="file_delete(this, '${fileName}')">삭제</div>
		                            	<input type="hidden" name="fileName" value="${fileName}">
		                            	<input type="hidden" name="fileSize" value="${fileSize[st.index]}">
		                            </div>
		                        </c:forTokens>
	                        </div>
	                    </c:if>
                        <div class="txt">파일 추가</div>
                        <input type="file" name="attachments" id="file" multiple>
                    </div>

                    <hr>

                    <div id="contents_wrap">
                        <div>* 내용</div>
                        <textarea name="contents" id="contents" cols="30" rows="10">${post.contents}</textarea>
                    </div>

                    <hr>

                    <div id="edit_btn">
                    	<input type="hidden" name="no" value="${post.no}">
                        <input type="button" id="reg" value="수정" onclick="edit()">
                    </div>
                    <input type="hidden" id="userId" value="${id}">
                </form>
            </div>
            
        </main>