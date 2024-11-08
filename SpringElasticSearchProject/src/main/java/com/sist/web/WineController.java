package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WineController {
  @GetMapping("wine/find.do")
  public String wine_find()
  {
	  return "wine/find";
  }
}
