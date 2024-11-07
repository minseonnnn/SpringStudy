package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Ŭ���� ��� (�����̳�)
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app1.xml");
		// classpath : �ڵ� �ν��ϴ� ��ġ => src/main/java
		Sawon sa1=(Sawon)app.getBean("sa1");
		sa1.print();
		System.out.println("============");
		Sawon sa2=(Sawon)app.getBean("sa2");
		sa2.print();
		System.out.println("============");
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.print();
		/*
		 *    ====================
		 *     id       ��ü
		 *    ====================
		 *     sa1      new Sawon()
		 *    ====================
		 *     sa2      new Sawon()
		 *    ====================
		 *     sa3      new Sawon()
		 *    ====================
		 */
	}

}
