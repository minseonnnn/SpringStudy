package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *   1. XML ���� => ��� 
 *   2. ���� => ������̼� 
 *   ===================== ���� 
 *   3. ��� => Container ���� 
 *        DI 
 *        AOP
 *        MVC 
 *        Transaction 
 *        Security 
 *        WebScoket 
 *        Betch : �����췯 
 *        ==============
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("application.xml");
        Sawon sa=(Sawon)app.getBean("sa");
        sa.setSabun(5);
        sa.setName("������");
        sa.setDept("�ѹ���");
        sa.print();
        //System.out.println(sa);
        Sawon sa1=(Sawon)app.getBean("sa");
        sa1.print();
        //System.out.println(sa1);
        Sawon sa3=(Sawon)app.getBean("sa");
        sa3.print();
        //System.out.println(sa3);
        Sawon sa4=(Sawon)app.getBean("sa");
        sa4.print();
        //System.out.println(sa4);
        // setter => �ʱ�ȭ 
        //System.out.println(sa);
        sa.print();
        Sawon sa2=(Sawon)app.getBean("sa2");
        // ������ => �ʱ�ȭ 
        sa2.print();
	}

}