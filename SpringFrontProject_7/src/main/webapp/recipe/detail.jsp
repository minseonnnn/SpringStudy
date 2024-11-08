<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <div class="row">
     <div class="col-12">
      <h2>레시피 상세보기</h2>
     </div>
    </div>
   <div class="container" id="detailApp"> 
    <div class="col-12 col-lg-8">
                  <table class="table">
                   <tr>
                     <td class="text-center" colspan="3">
                       <img :src="vo.poster" style="width: 800px; height: 380px">
                     </td>
                   </tr>
                   <tr>
                     <td class="text-center" colspan="3">
                       <h3>{{vo.title}}</h3>
                     </td>
                   </tr>
                   <tr>
                     <td class="text-center" colspan="3">{{vo.content}}</td>
                   </tr>
                   <tr>
                    <td class="text-center"><img src="../img/icon/a1.png"></td>
                    <td class="text-center"><img src="../img/icon/a2.png"></td>
                    <td class="text-center"><img src="../img/icon/a2.png"></td>
                   </tr>
                   <tr>
                    <td class="text-center">{{vo.info1}}</td>
                    <td class="text-center">{{vo.info2}}</td>
                    <td class="text-center">{{vo.info3}}</td>
                   </tr>
                  </table>
                  <h5>[재료]</h5>
                  <table class="table">
                    <tr>
                     <td>
                       <ul style="list-style-type: none">
                         <li v-for="d in datas">{{d}}</li>
                       </ul>
                     </td>
                    </tr>
                  </table>
                  <h5>[조리순서]</h5>
                  <table class="table">
                    <tr>
                      <td>
                        <table class="table" v-for="(m,index) in makes">
                          <tr>
                            <td width="80%" class="text-left">
                              <h5>{{m}}</h5>
                            </td>
                            <td width="20%" class="text-right">
                              <img :src="images[index]" style="width: 120px; height: 100px">
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <h5>[레시피 작성자]</h5>
                  <table class="table">
                    <tr>
                      <td width="20%" class="text-center" rowspan="2">
                        <img :src="vo.chef_poster" style="width: 100px; height: 100px" class="img-circle">
                      </td>
                      <td width="80%">{{vo.chef}}</td>
                    </tr>
                    <tr>
                      <td width="80%">{{vo.chef_profile}}</td>
                 </tr>
            </table>
        </div>
     </div> 
  </div>
  <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    			vo:{},
    			no:${no},
    			makes:[],
    			images:[],
    			datas:[]
    		}
    	},
    	mounted(){
    		axios.get('../recipe/detail_vue.do',{
    			params:{
    				no:this.no
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data.vo
    			this.makes=response.data.mList
    			this.images=response.data.iList
    			this.datas=response.data.vo.data.split(",")
    		}).catch(error=>{
    			console.log(error.response)
    		})
    	}
    }).mount('#detailApp')
  </script>  
</body>
</html>