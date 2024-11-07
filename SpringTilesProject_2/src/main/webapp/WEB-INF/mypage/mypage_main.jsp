<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <tiles:insertAttribute name="header"/>
   <div class="col-sm-3">
     <tiles:insertAttribute name="menu"/>
   </div>
   <div class="col-sm-9">
     <tiles:insertAttribute name="content"/>
   </div>
</body>
</html>