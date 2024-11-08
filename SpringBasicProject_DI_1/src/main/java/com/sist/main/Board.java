package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
  private int bno;
  private String name;
  private String subject;
  
  public void print()
  {
	  System.out.println("번호:"+bno);
	  System.out.println("이름:"+name);
	  System.out.println("제목:"+subject);
  }
}
