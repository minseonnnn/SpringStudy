<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
    margin: 0px auto;
    width: 800px;
}
</style>
</head>
<body>
   <div class="container">
     <h3 class="text-center">수정하기</h3>
     <div class="row">
     <form method="post" action="update_ok.do">
      <table class="table">
        <tr>
         <th class="text-right" width=20%>이름</th>
         <td width=80%>
           <input type=text name=name size=20 class="input-sm" value="${vo.name }">
           <input type="hidden" name=no value="${vo.no }">
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>제목</th>
         <td width=80%>
           <input type=text name=subject size=50 class="input-sm" value="${vo.subject }">
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>내용</th>
         <td width=80%>
           <textarea rows="10" cols="50" name="content">${vo.content }</textarea>
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>비밀번호</th>
         <td width=80%>
           <input type=password name=pwd size=10 class="input-sm">
         </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn-sm btn-info">수정</button>
            <input type=button class="btn-sm btn-warning"
              value="취소" onclick="javascript:history.go(-1)">
          </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>