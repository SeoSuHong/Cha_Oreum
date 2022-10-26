<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<main>
        
            <div>
                <form name="editForm" action="edit" method="post" enctype="multipart/form-data">
                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title" value="${notice.title}">
                    </div>

                    <hr>

                    <div id="contents_wrap">
                        <div>* 내용</div>
                        <textarea name="contents" id="contents" cols="30" rows="10">${notice.contents}</textarea>
                    </div>

                    <hr>

                    <div id="edit_btn">
                    	<input type="hidden" name="no" value="${notice.no}">
                        <input type="button" id="edit" value="수정" onclick="editPost()">
                        <input type="hidden" id="adminId" value="${id}">
                    </div>
                </form>
            </div>
            
        </main>