package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import java.io.*;
import java.net.*;
@RestController
public class WineRestController {
  @GetMapping(value = "wine/find_vue.do", produces = "text/plain;charset=UTF-8")
  public String wine_find(String namekor) throws Exception
  {
	  
	  String strUrl="http://localhost:9200/wine/_search?q=namekor="
			  +URLEncoder.encode(namekor,"UTF-8");
	  URL url=new URL(strUrl);
	  
	  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
	  StringBuffer sb=new StringBuffer();
	  if(conn!=null)
	  {
		  BufferedReader in=
				  new BufferedReader(
						  new InputStreamReader(conn.getInputStream(),"UTF-8"));
		  while(true)
		  {
			  String data=in.readLine();
			  if(data==null) break;
			  sb.append(data);
		  }
		  in.close();
	  }
	  return sb.toString();
  }
}
