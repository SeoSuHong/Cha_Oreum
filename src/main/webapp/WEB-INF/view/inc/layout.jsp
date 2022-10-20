<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../image/headLogo.png" rel="shortcut icon" type="image/x-icon">
    <title>Cha Oreum</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="css/inc/layout.css">
    <link rel="stylesheet" href="<tiles:getAsString name="css" />">
    <script src="js/inc/header.js"></script>
    <script src="js/inc/aside.js"></script>
    <script src="<tiles:getAsString name="js" />"></script>
</head>
<body>
    <!-- header -->
    <tiles:insertAttribute name="header" />

    <!------------------------------------------------------------------------------------->
    
    <form id="indexForm" name="indexForm" action="/" method="get">
        <div id="body">

            <!-- aside -->
    		<tiles:insertAttribute name="aside" />        

            <!------------------------------------------------------------------------------------->

            <!-- main -->
            <tiles:insertAttribute name="main" />

            <!------------------------------------------------------------------------------------->

            <input type="hidden" name="c" id="category" value="${c}">
            <input type="hidden" name="t" id="title" value="${t}">
            <input type="hidden" name="n" id="nickname" value="${n}">
            <input type="hidden" name="s" id="sort" value="${s}">
            <input type="hidden" name="p" id="page" value="${p}">
        </div>
    </form>

    <!-- footer -->
    <tiles:insertAttribute name="footer" />
    
</body>
</html>