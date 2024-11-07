package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefController {
  @GetMapping("chef/list.do")
  public String chef_list()
  {
	  return "chef/make";
  }

}
