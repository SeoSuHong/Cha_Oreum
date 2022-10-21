<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!-- aside -->
            <aside>
                <div id="hideMenu"><img src="/image/hideMenu.png" alt="숨기기" class="hide_btn"></div>
                <div id="showMenu"><img src="/image/showMenu.png" alt="보이기" class="show_btn"></div>
                <div id="aside_wrap">
                    <div id="menu_btn">
                    
                        <c:if test="${empty nickname || nickname ne n}">
	                        <input type="button" id="world" value="World" style="color: #38424A" onclick="location.href='/'">
	                        <input type="button" id="my" value="My" style="color: #AEAEAE" onclick="myContents('${nickname}')">
	                    </c:if>
	                    
                    	<c:if test="${not empty nickname && nickname eq n}">
	                        <input type="button" id="world" value="World" style="color: #AEAEAE" onclick="location.href='/'">
	                        <input type="button" id="my" value="My" style="color: #38424A" onclick="myContents('${nickname}')">
                        </c:if>
                        
                    </div>
                    <div id="category">
                    
                    	<c:if test="${empty mainCategories}">
                    		<div id="emptyCategory">등록된 개시글이 없습니다.</div>
                    	</c:if>
                    
                    	<c:forEach var="mainCategory" items="${mainCategories}">
	                    	<div class="mainCategory">${mainCategory.name}</div>
	                        <div class="sub">
	                        	<c:forEach var="subCategory" items="${subCategories}">
	                        		<c:if test="${mainCategory.no eq subCategory.mainCategory_no}">
	                        			<c:if test="${nickname eq n}">
			                            	<div class="subCategory" onclick="category(${subCategory.no}, '${nickname}')"><p>${subCategory.name}</p></div>
			                            </c:if>
			                            <c:if test="${nickname ne n}">
			                            	<div class="subCategory" onclick="category(${subCategory.no}, '')"><p>${subCategory.name}</p></div>
			                            </c:if>
			                        </c:if>
		                        </c:forEach>
	                        </div>
                        </c:forEach>
                        
                    </div>
                </div>

            </aside>