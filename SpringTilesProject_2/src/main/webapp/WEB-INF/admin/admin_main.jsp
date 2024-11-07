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
   <tiles:insertAttribute name="headera"/>
   <div class="container">
   <div class="col-sm-2">
     <tiles:insertAttribute name="menua"/>
   </div>
   <div class="col-sm-8">
     <tiles:insertAttribute name="contenta"/>
     </div>
   </div>
</body>
</html>