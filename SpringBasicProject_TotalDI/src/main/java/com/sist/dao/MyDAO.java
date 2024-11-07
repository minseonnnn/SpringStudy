package com.sist.dao;

public class MyDAO {
   // getConnection  / disConnection 
   // 공통으로 사용되는 부분 
   //=========================================
   public void getConnection()
   {
	   System.out.println("오라클 연결");
   }
   public void disConnection()
   {
	   System.out.println("오라클 해제");
   }
   //========================================= AOP대상
   // AOP는 OOP에서 하지 못하는 자동 호출이 가능하게 만든 상태 : OOP를 보완
   public void select()
   {
	   //getConnection(); // before
	   System.out.println("SELECT문장 처리");
	   //disConnection(); // after
   }
   public void insert()
   {
	   //getConnection();
	   System.out.println("INSERT문장 처리");
	   //disConnection();
   }
   public void update()
   {
	   //getConnection();
	   System.out.println("UPDATE문장 처리");
	   //disConnection();
   }
   public void delete()
   {
	   //getConnection();
	   int a=10/0;
	   System.out.println("a="+a);
	   System.out.println("DELETE문장 처리");
	   
	   //disConnection();
   }
   public String find(String fd)
   {
	   return fd+"찾기 완료~~";
   }
   
   
}
