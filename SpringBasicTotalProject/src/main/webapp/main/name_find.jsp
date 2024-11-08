<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px
}
.row {
  margin: 0px auto;
  width: 800px
}
</style>
</head>
<body>
   <div class="container">
     <h3 class="text-center">이름으로 찾기(forEach)</h3>
     <div class="row">
      <form method="post" action="name_find_ok.do">
       <table class="table">
        <tr>
          <td>
            <c:forEach var="name" items="${names }">
             <input type="checkbox" name="names" value="${name }">${name }
            </c:forEach>
          </td>
        </tr>
        <tr>
          <td class="text-center">
            <button class="btn-sm btn-primary">검색</button>
          </td>
        </tr>
       </table>
      </form> 
     </div>
   </div>
</body>
</html>