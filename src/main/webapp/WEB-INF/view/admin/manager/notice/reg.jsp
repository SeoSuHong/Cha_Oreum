<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<main>
        
            <div>
                <form name="regForm" action="reg" method="post" enctype="multipart/form-data">
                    
                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title">
                    </div>

                    <hr>

                    <div id="contents_wrap">
                        <div>* 내용</div>
                        <textarea name="contents" id="contents" cols="30" rows="10"></textarea>
                    </div>

                    <hr>

                    <div id="reg_btn">
                        <input type="button" id="reg" value="작성" onclick="regPost()">
                    </div>
                    <input type="hidden" id="adminId" value="${id}">
                </form>
            </div>
            
        </main>