<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
   <table class="table">
    <tr>
     <td class="text-center" colspan="3">
      <img src="${vo.poster }" style="width: 800px; height: 300px">
     </td>
    </tr>
    <tr>
      <td class="text-center" colspan="3"><h3>${vo.title }</h3></td>
     </tr>
     <tr>
      <td class="text-center" colspan="3">${vo.content }</td>
     </tr>
     <tr>
      <td class="text-center"><img src="../images/a1.png"></td>
      <td class="text-center"><img src="../images/a2.png"></td>
      <td class="text-center"><img src="../images/a3.png"></td>
     </tr>
      <tr>
      <td class="text-center">${vo.info1 }</td>
      <td class="text-center">${vo.info2 }</td>
      <td class="text-center">${vo.info3 }</td>
     </tr>
   </table>
   <h4>[재료]</h4>
   <table class="table">
     <tr>
      <td>
        <ul style="list-style-type: none">
         <c:forTokens items="${vo.data }" delims="," var="d">
          <li>${d }</li>
         </c:forTokens>
        </ul>
      </td>
     </tr>
   </table>
   <h4>[조리순서]</h4>
   <table class="table">
    <tr>
     <td>
      <c:forEach var="make" items="${mList }" varStatus="s">
        <table class="table">
         <tr>
          <td width="80%"><h5>${make }</h5></td>
          <td width="20%"><img src="${iList[s.index] }" style="width: 150px; height: 100px" class="img-rounded"></td>
         </tr>
        </table>
      </c:forEach>
     </td>
    </tr>
   </table>
   <h4>[레시피 작성자]</h4>
   <table class="table">
    <tr>
     <td width="30%" rowspan="3" class="text-center">
      <img src="${vo.chef_poster }" style="width: 150px; height: 130px;" class="img-circle">
     </td>
     <td>${vo.chef }</td>
    </tr>
    <tr>
     <td>${vo.chef_profile }</td>
    </tr>
    <tr>
     <td class="text-right">
      <a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
     </td>
    </tr>
   </table>
  </div>
</body>
</html>