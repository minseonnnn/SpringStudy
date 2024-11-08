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
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 960px
}
p{
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
}
input[type="button"]{
   margin-left: 5px
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <div class="row">
      <div class="text-center">
         <input type="button" class="btn-sm btn-info" value="한식"
          @click="typeChange('한식')"
         >
         <input type="button" class="btn-sm btn-primary" value="양식"
          @click="typeChange('양식')"
         >
         <input type="button" class="btn-sm btn-success" value="중식"
          @click="typeChange('중식')"
         >
         <input type="button" class="btn-sm btn-warning" value="일식"
          @click="typeChange('일식')"
         >
         <input type="button" class="btn-sm btn-danger" value="분식"
          @click="typeChange('분식')"
         >
      </div>   
     </div>
     <%-- 
           일반 속성에 값을 첨부 => :을 사용하지 않으면 Vue 변수를 사용할 수 없다
           => Vue 변수 출력 시에는 :속성
           태그와 태그 사이 값 => {{변수}} => react:{} 
     --%>
     <div style="height: 10px"></div>
     <div class="row">
         <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a :href="'detail.do?fno='+vo.fno+'&page='+curpage">
		        <img :src="'http://www.menupan.com'+vo.poster" :title="vo.type" 
		        style="width:230px; height: 130px">
		         <div class="caption">
		          <p>{{vo.name}}</p>
		         </div>
		       </a>
		    </div>
        </div>
     </div>
    <div style="height: 10px"></div>
    <div class="row">
      <div class="text-center">
        <input type="button" class="btn-sm btn-info" value="이전"
         @click="prev()"
        >
        {{curpage}} page / {{totalpage}} pages
        <input type="button" class="btn-sm btn-primary" value="다음"
         @click="next()"
        >
      </div>
    </div> 
  </div>
  <script>
    let listApp=Vue.createApp({
    	data(){
    		return {
    			food_list:[],
    			curpage:1,
    			totalpage:0,
    			type:'한식'
    		}
    	},
    	// 화면 출력 전에 변수의 초기화 => 서버 연결 => axios.get
    	// 반복 => 첫 화면 , 페이지 (이전,다음) => 함수로 제작 => 호출 
    	mounted(){
    		this.dataRecv()
    	},
    	methods:{
    		// 서버연결 반복 => 제거  list_vue.do?page=1&type=한식
    		/*
    		    $.ajax({
    		    	type:  => get() , post() , put() , delete()
    		    	url: => 함수 안에
    		    	data:=> params
    		    	success:function(response)
    		    	{
    		    		then(function(response){})
    		    		then(response=>{})
    		    	},
    		    	error:function()
    		    	{
    		    		catch()
    		    	}
    		    })
    		    
    		    => 요청 / 응답을 동시에 처리 
    		    => 화면을 변경하지 않고 자체에서 처리 
    		       ============== 속도가 빠르다 
    		*/
    		dataRecv()
    		{
    		    	axios.get('list_vue.do',{
    	    			// Ajax => data:{page:1,type:'한식'}
    	    			params:{
    	    				page:this.curpage,
    	    				type:this.type
    	    			}
    	    		}).then(response=>{
    	    			console.log(response.data)
    	    			this.food_list=response.data.list
    	    			this.curpage=response.data.curpage
    	    			this.totalpage=response.data.totalpage
    	    			this.type=response.data.type
    	    		}).catch(error=>{
    	    			console.log(error.response)
    	    		})
    		},
    		typeChange(type){
    			this.type=type
    			this.curpage=1
    			this.dataRecv()
    		},
    		prev(){
    			this.curpage=this.curpage>1?this.curpage-1:this.curpage
    			this.dataRecv()
    		},
    		next(){
    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
    	    	this.dataRecv()
    		}
    	}
    	/*
    	    1. 전체 코딩 
    	    2. 반복 ============= 공통 모듈 : AOP
    	    3. 재사용 부분 
    	    ============= 메소드화 
    	*/
    }).mount('.container')
  </script> 
</body>
</html>