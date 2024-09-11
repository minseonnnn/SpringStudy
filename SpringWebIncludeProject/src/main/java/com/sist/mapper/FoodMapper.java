package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit num "
		    +"FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit,rownum as num "
		    +"FROM (SELECT /*+ INDEX_ASC(project_food_house fh_fno_pk)*/fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit "
		    +"FROM project_food_house ORDER BY fno DESC)) "
		    +"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT COUNT(*) FROM project_food_house")
	public int foodRowCount();
	
	@Update("UPDATE project_food_house SET "
			+"hit=hit+1 "
			+"WHERE fno=#{fno}")
	 public void foodHitIncrement(int fno);
	 
	@Select("SELECT fno,poster,name,score,address,phone,theme,type,time,parking "
			 +"FROM project_food_house "
			 +"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	 
	 @Select("SELECT fno,name,poster "
			 +"FROM project_food_house "
			 +"WHERE fno=#{fno}")
	 public FoodVO foodCookieInfoData(int fno);
}
