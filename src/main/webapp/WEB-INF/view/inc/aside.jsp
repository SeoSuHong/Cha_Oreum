<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!-- aside -->
            <aside>
                <div id="hideMenu"><img src="../image/hideMenu.png" alt="숨기기" class="hide_btn"></div>
                <div id="showMenu"><img src="../image/showMenu.png" alt="보이기" class="show_btn"></div>
                <div id="aside_wrap">
                    <div id="menu_btn">
                        <button id="world">World</button>
                        <button id="my">My</button>
                    </div>
                    <div id="category">
                    	<c:forEach var="mainCategory" items="${mainCategories}">
	                    	<div class="mainCategory">${mainCategory}</div>
	                        <div class="sub">
	                        	<c:forEach var="subCategory" items="${subCategories}">
	                        		<c:if test="${mainCategory eq subCategory.mainCategory_name}">
			                            <div class="subCategory"><p>${subCategory.name}</p></div>
			                        </c:if>
		                        </c:forEach>
	                        </div>
                        </c:forEach>
                        <!-- <div class="mainCategory">Language</div>
                        <div class="sub">
                            <div class="subCategory"><p>JAVA</p></div>
                            <div class="subCategory"><p>Python</p></div>
                            <div class="subCategory"><p>C</p></div>
                        </div>

                        <div class="mainCategory">Front-End</div>
                        <div class="sub">
                            <div class="subCategory"><p>HTML</p></div>
                            <div class="subCategory"><p>CSS</p></div>
                            <div class="subCategory"><p>JavaScript</p></div>
                        </div>

                        <div class="mainCategory">Back-End</div>
                        <div class="sub">
                            <div class="subCategory"><p>PHP</p></div>
                            <div class="subCategory"><p>JSP</p></div>
                            <div class="subCategory"><p>Spring</p></div>
                        </div>

                        <div class="mainCategory">Database</div>
                        <div class="sub">
                            <div class="subCategory"><p>Oracle</p></div>
                            <div class="subCategory"><p>MySQL</p></div>
                        </div>

                        <div class="mainCategory">Project Management</div>
                        <div class="sub">
                            <div class="subCategory"><p>GitHub</p></div>
                        </div>

                        <div class="mainCategory">ETC</div>
                        <div class="sub">
                            <div class="subCategory"><p>Error</p></div>
                            <div class="subCategory"><p>QnA</p></div>
                        </div> -->
                        
                    </div>
                </div>

            </aside>