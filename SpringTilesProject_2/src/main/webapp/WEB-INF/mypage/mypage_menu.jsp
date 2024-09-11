<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
  <div class="panel panel-info">
    <div class="panel-heading">
      <h3 class="panel-title">개인정보</h3>
    </div>
    <ul class="list-group">
     <li class="list-group-item"><a href="../mypage/mypage_joinupdate.do">회원 수정</a>
     <li class="list-group-item"><a href="#">회원 탈퇴</a>
    </ul>
  </div>
  <div style="height: 10px"></div>
  <div class="panel panel-warning">
    <div class="panel-heading">
      <h3 class="panel-title">관리정보</h3>
    </div>
    <ul class="list-group">
     <li class="list-group-item"><a href="../mypage/mypage_jjim.do">찜 관리</a>
     <li class="list-group-item"><a href="#">예약 관리</a>
    </ul>
  </div>
</body>
</html>