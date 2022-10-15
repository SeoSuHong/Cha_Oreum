<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<main>
        
            <div>
                <form name="regForm" action="/contents/reg" method="post" enctype="multipart/form-data">
                    <div id="regCategory">
                        <div>* Main Category</div>
                        <select name="mainCategory" id="mainCategory" onchange="changeMainCategory()">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <c:forEach var="mainCategory" items="${mainCategories}">
                            	<option value="${mainCategory.no}">${mainCategory.name}</option>
                            </c:forEach>
                        </select>

                        <div>* Sub Category</div>
                        <select name="subCategory" id="subCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                        </select>
                    </div>

                    <hr>

                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title">
                    </div>

                    <hr>

                    <div id="file_wrap">
                        <div>첨부 파일</div>
                        <input type="file" name="filess" id="file" multiple>
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
                </form>
            </div>
            
        </main>