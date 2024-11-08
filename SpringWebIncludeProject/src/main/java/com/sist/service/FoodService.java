package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;

public interface FoodService {
     public List<FoodVO> foodListData(Map map);
	 public int foodRowCount();
	 public FoodVO foodDetailData(int fno);
	 public FoodVO foodCookieInfoData(int fno);
}
