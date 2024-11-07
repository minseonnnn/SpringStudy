package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class DAOAop {
   public void before()
   {
	   System.out.println("����Ŭ ����");
   }
   public void after()
   {
	   System.out.println("����Ŭ ����");
   }
   // around 
   // �ٽ� �ڵ� => 
   // => �ٽ� ó�� / ���� ó��
   /*
    *     getConnection(); ----
	      System.out.println("DELETE���� ó��"); : �ٽ� 
	      disConnection(); ---- ���� 
	      
	      MyBatis 
	      => ���̺귯�� => ���� ���κд� ���� 
	      
	      around 
	      
	      ======= ����
	        OOOOOO => �ٽ� 
	      ======= ���� 
	      
	      => Ʈ����� ó�� setAutoCommit(false)
	                    ó��
	                    commit()
	      => LOG���� 
	      
	      ó�� 
	      =====================
	      CommonsModel.footerData()
	      
	      public void execution()
	      {
	          before�� ��ϵ� �޼ҵ� ȣ�� ==> 
	              ��� �޼ҵ� , ������ �޼ҵ忡 �������� ������ �Ǵ� �κ��� �ִ� ��� 
	          try
	          {
	             around
	             ====> �ٽ� �ڵ�
	             around  
	          }catch(Exception e)
	          {
	             after-throwing 
	          }
	          finally
	          {
	             after
	          }
	          return; after-returning 
	      }
	      
	      =====================
    */
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   long start=System.currentTimeMillis();
	   System.out.println("ȣ��� �޼ҵ�:"+jp.getSignature().getName());
	   obj=jp.proceed(); // ����ڰ� ��û�� �޼ҵ带 ȣ�� 
	   long end=System.currentTimeMillis();
	   System.out.println("�ҿ�ð�:"+(end-start));
	   return obj;   
   }
   
   public void afterRetruning(Object obj)
   {
	   System.out.println("====== ����� �ڵ� ó�� =====");
	   System.out.println("�����:"+obj);
   }
   
   public void afterThrowing(Throwable ex)
   {
	   System.out.println("====== ���ܹ߻� ======");
	   System.out.println(ex.getMessage());
   }
}
