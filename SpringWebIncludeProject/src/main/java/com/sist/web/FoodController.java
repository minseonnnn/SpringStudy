package com.sist.web;


import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class FoodController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("food/list.do")
	public String food_list(String page,Model model,HttpServletRequest request)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<FoodVO> flist=fService.foodListData(map);
		int count=fService.foodRowCount();
		int totalpage=(int)(Math.ceil(count/20.0));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		Cookie[] cookies = request.getCookies();
	       List<FoodVO> clist = new ArrayList<>();

	       if (cookies != null) {
	           for (int i = cookies.length - 1; i >= 0; i--) {
	               if (cookies[i].getName().startsWith("food_")) {
	                   String fno = cookies[i].getValue();
	                   FoodVO vo = fService.foodCookieInfoData(Integer.parseInt(fno));
	                   clist.add(vo);
	               }
	           }
	       }
	       
	    model.addAttribute("size",clist.size());
		model.addAttribute("flist",flist);
		model.addAttribute("clist",clist);
		model.addAttribute("count",count);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
	@GetMapping("food/detail.do")
	   public String food_detail(int fno, HttpServletResponse response, RedirectAttributes ra) {

		   Cookie cookie = new Cookie("food_" + fno, String.valueOf(fno));
	       cookie.setMaxAge(60 * 60 * 24); // 1 day
	       cookie.setPath("/");
	       response.addCookie(cookie);
	       
	       ra.addAttribute("fno", fno);
	       return "redirect:../food/detail_before.do";
	   }

	   @GetMapping("food/detail_before.do")
	   public String food_detail_before(int fno, Model model) {
	       FoodVO vo = fService.foodDetailData(fno);

	       model.addAttribute("vo", vo);
	       model.addAttribute("main_jsp", "../food/detail.jsp");

	       return "main/main";
	   }

	   @GetMapping("food/cookie_all.do")
	   public String food_cookie_all(HttpServletRequest request, Model model) {
	       Cookie[] cookies = request.getCookies();
	       List<FoodVO> clist = new ArrayList<>();

	       if (cookies != null) {
	           for (int i = cookies.length - 1; i >= 0; i--) {
	               if (cookies[i].getName().startsWith("food_")) {
	                   String fno = cookies[i].getValue();
	                   FoodVO vo = fService.foodCookieInfoData(Integer.parseInt(fno));
	                   clist.add(vo);
	               }
	           }
	       }

	       model.addAttribute("clist", clist);
	       model.addAttribute("size", clist.size());
	       model.addAttribute("main_jsp", "../food/cookie_all.jsp");

	       return "main/main";
	   }

	   @GetMapping("food/cookie_delete.do")
	   public String food_cookie_delete(HttpServletRequest request, HttpServletResponse response) {
	       Cookie[] cookies = request.getCookies();

	       if (cookies != null) {
	           for (Cookie cookie : cookies) {
	               if (cookie.getName().startsWith("food_")) {
	                   cookie.setPath("/");
	                   cookie.setMaxAge(0);
	                   response.addCookie(cookie);
	               }
	           }
	       }

	       return "redirect:../food/list.do";
	   }
	}