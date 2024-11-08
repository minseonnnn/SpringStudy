<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js">
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 1100px;
   
}
.nav-link{
   cursor: pointer;
}
p{
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td class="text-center" width="30%" height="500">
          <div style="overflow-y: auto; height: 500px"> 
            
            <table class="table">
              <caption><h3>맛집 정보</h3></caption>
              <tr>
                <td class="text-center" colspan="2">
                  <button class="btn-xs btn-info" @click="typeChange('한식')">한식</button>
                  <button class="btn-xs btn-primary" @click="typeChange('양식')">양식</button>
                  <button class="btn-xs btn-success" @click="typeChange('중식')">중식</button>
                  <button class="btn-xs btn-warning" @click="typeChange('일식')">일식</button>
                  <button class="btn-xs btn-danger" @click="typeChange('분식')">분식</button>
                </td>
              </tr>
               
              <tr v-for="(vo,index) in food_list" class="nav-link" @click="foodSelect(index)">
                 <td class="text-center" width="30%">
                   <img :src="'http://www.menupan.com'+vo.poster" style="width:30px; height: 30px">
                 </td>
                 <td width="70%">{{vo.name}}</td>
               </tr>
            </table>
          </div>
          </td>
          <td class="text-center" width=40% height="500">
            <table class="table" v-show="isDay"> 
              <caption><h3>예약일 정보</h3></caption>
              <tr>
               <td>
                 <div id="calendar"></div>
               </td>
              </tr>
            </table>
          </td>
          <td class="text-center" width=30% rowspan="2">
            <table class="table">
              <caption><h3>예약 정보</h3></caption>
              <tr>
                <td class="text-center" colspan="2">
                <img :src="'http://www.menupan.com'+food_detail.poster" style="width: 200px;height: 150px">
                </td>
              </tr>
              <tr>
                <th class="text-left" width="30%">업체명</th>
                <td width="70%" class="text-left">{{food_detail.name}}</td>
              </tr>
              <tr>
                <th class="text-left" width="30%">예약일</th>
                <td width="70%" class="text-left">{{rday}}</td>
              </tr>
              <tr>
                <th class="text-left" width="40%">예약 시간</th>
                <td width="60%" class="text-left">{{ts}}</td>
              </tr>
              <tr>
                <th class="text-left" width="30%">인원</th>
                <td width="70%" class="text-left">{{is}}</td>
              </tr>
              <tr v-show="reserveBtn">
                <td colspan="2" class="text-center">
                 <button class="btn-light btn-lg">예약</button>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td class="text-center" width=40% height="200">
            <table class="table" v-show="isTime">
              <caption><h3>시간 정보</h3></caption>
              <tr>
                <td>
                  <span class="btn btn-xs btn-info" style="margin-left: 2px" v-for="t in rtime"
                  @click="timeSelect(t)"
                  >{{t}}</span>
                </td>
              </tr>
            </table>
          </td>
          <td class="text-center" width=30% height="200">
            <table class="table" v-show="isInwon">
              <caption><h3>인원 정보</h3></caption>
              <tr>
                <td class="text-center">
                 <span class="btn btn-xs btn-primary" 
                 v-for="i in inwon"
                 @click="inwonSelect(i)"
                 >{{i}}</span>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <script>
    let rApp=Vue.createApp({
    	data(){
    		return {
    			isDay:false,
    			isTime:false,
    			isInwon:false,
    			food_list:[],
    			type:'한식',
    			food_detail:{},
    			rday:'',
    			rtime:['10:00','11:00','12:00','13:00',
    				   '14:00','15:00','16:00','17:00',
    				   '18:00','19:00','20:00','21:00'],
    		    ts:'',
    		    inwon:['1명','2명','3명','4명','5명',
    		    	   '6명','7명','8명','9명','10명','단체'],
    		    is:'',
    		    reserve:false
    		}
    	},
    	mounted(){
    		let date=new Date()
    		let year=date.getFullYear()
    		let month=date.getMonth()+1//("0"+(1+date.getMonth())).slice(-2);
    		let day=date.getDate()//("0"+date.getDate()).slice(-2)
    		// 시작과 동시에 변수 초기화
    		let _this=this
    		document.addEventListener('DOMContentLoaded',function(){
    			let calendarEl=document.getElementById('calendar')
    			let calendar=new FullCalendar.Calendar(calendarEl,{
    				initialView:'dayGridMonth',
    				height:450,
    				headerToolbar:{
    					left:'prev,next',
    					center:'title'
    				},
    				validRange:{
    					start:year+"-"+month+"-"+day
    				},
    				themeSystem:'bootstrap',
    				editable:true,
    				dropable:true,
    				dateClick:((info)=>{
    					//alert('click date:'+info.dateStr)
    					_this.isTime=true
    					_this.rday=info.dateStr
    					// FullCalendar => this
    					// _this => Vue
    					// 모든 클래스는 this를 가지고 있다 
    				})
    			})
    			calendar.render()
    		})
    		this.dataRecv()
    	},
    	methods:{
    		inwonSelect(i){
    			this.is=i
    			this.reserveBtn=true
    		},
    		timeSelect(time){
    			this.isInwon=true
    			this.ts=time
    		},
    		// 사용자 정의 메소드
    		typeChange(type){
    			this.type=type
    			this.dataRecv()
    		},
    		dataRecv(){
    			axios.get('../food/type_vue.do',{
    				params:{
    					type:this.type
    				}
    			}).then(response=>{
    				console.log(response.data)
    				this.food_list=response.data
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		},
    		foodSelect(index){
    			this.isDay=true
    			this.food_detail=this.food_list[index]
    			console.log(this.food_detail)
    		}
    	},
    	updated(){
    		
    	},
        components:{
    		// 등록
    	},
    }).mount('.container')
  </script>
</body>
</html>