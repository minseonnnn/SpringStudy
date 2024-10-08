package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class CommentRestController {
  @Autowired
  private CommentService cService;
  
  public String commonsListData(int page,int rno,int type)
  {
	  Map map=new HashMap();
	  int rowSize=10;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  
	  map.put("start", start);
	  map.put("end", end);
	  map.put("rno", rno);
	  map.put("type", type);
	  
	  return "";
  }
  @GetMapping(value = "comment/list_vue.do", produces = "text/plain;charset=UTF-8")
  public String comment_list(int page, int rno)
  {
	  return "";
  }
}
