<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#chatArea{
    height: 450px;
    overflow-y: auto;
    border: 1px solid black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script>
let websocket
function connection()
{
     // 서버 연결
     websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws")
     websocket.onopen=onOpen
     websocket.onclose=onClose
     websocket.onmessage=onMessage
}
// => CallBackBack 함수 처리
// 연결이 된 경우
function onOpen(event)
{
	alert("채팅서버에 연결되었습니다!!")
}
// 연결이 해제 된 경우
function onClose(event)
{
	alert("채팅 서버가 연결을 종료하였습니다")
}
// 메세지가 정상으로 전송 
function onMessage(event)
{
	// 서버에서 메세지를 받은 경우
	let data=event.data
	if(data.substring(0,4)==="msg:")
	{
		$('#recvMsg').append("<font color=red>"+data.substring(4)+"</font><br>")
	}	
	else if(data.substring(0,3)==="my:")
	{
		$('#recvMsg').append("<font color=blue>"+data.substring(3)+"</font><br>")
	}	
	else if(data.substring(0,4)==="you:")
	{
		$('#recvMsg').append(data.substring(4)+"<br>")
	}	
	// 스크롤 위치 저장 
	let ch=$('#chatArea').height()
	let m=$('#recvMsg').height()-ch
	$('#chatArea').scrollTop(m)
}
function disConnection()
{
	websocket.close()
	// div 출력 => 스크롤바 조절
}
function send()
{
	let msg=$('#sendMsg').val()
	if(msg.trim()==="")
	{
		$('#sendMsg').focus()
		return
	}	
	websocket.send(msg)
	$('#sendMsg').val("")
	$('#sendMsg').focus()
	// 서버로 데이터 전송
}
//이벤트 처리
$(function(){
	$('#inputBtn').click(function(){
		connection()
	})
	$('#outputBtn').click(function(){
		disConnection()
	})
	$('#sendBtn').click(function(){
		send()
	})
	$('#sendMsg').keydown(function(key){
		if(key.keyCode===13)
		{
			send()
		}	
	})
})
</script> 
</head>
<body>
 <!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>실시간 채팅</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                   <div class="row no-gutters">
                     <table class="table">
                       <tr>
                        <td>
                          <input type="button" class="btn-sm btn-info" value="입장" id="inputBtn">
                           <input type="button" class="btn-sm btn-warning" value="퇴장" id="outputBtn">
                        </td>
                       </tr>
                       <tr>
                         <td>
                           <div id="chatArea">
                             <div id="recvMsg"></div>
                           </div>
                         </td>
                       </tr>
                       <tr>
                         <td>
                           <input type=text id="sendMsg" class="input-sm" size=70>
                           <input type=button value="전송" class="btn-sm btn-primary" id="sendBtn">
                         </td>
                       </tr>
                     </table>
                   </div>
                </div>
            </div>
        </div>
    </section>                
</body>
</html>