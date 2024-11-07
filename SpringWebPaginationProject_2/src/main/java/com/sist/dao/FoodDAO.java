package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	/*
	 *   @Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit num "
			    +"FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit,rownum as num "
			    +"FROM (SELECT INDEX_ASC(project_food_house fh_fno_pk)fno,name,type,phone,address,score,theme,poster,images,time,parking,content,rdays,jjimcount,likecount,hit "
			    +"WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(Map map);
		
		@Select("SELECT COUNT(*) FROM project_food_house")
		public int foodRowCount();
	 */
	  public List<FoodVO> foodListData(Map map)
	  {
		  return mapper.foodListData(map);
	  }
	  public int foodRowCount()
	  {
		  return mapper.foodRowCount();
	  }

}
