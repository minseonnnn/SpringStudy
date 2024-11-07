package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ChefVO;
import com.sist.vo.FoodVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;
import com.sist.vo.ReplyBoardVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public RecipeDetailVO recipeDetailData(int no);
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
	public List<RecipeVO> chefMakeRecipeData(Map map);
	public int chefMakeRecipeTotalPage(String chef);
	public RecipeVO recipeCookieInfoData(int no);
	public List<RecipeVO> recipeFindData(Map map);
    public int recipeFindTotalPage(Map map);
    public List<FoodVO> foodTop5Data();
    public List<RecipeVO> recipeTop5Data();
    
}
