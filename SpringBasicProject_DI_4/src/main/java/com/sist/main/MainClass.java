package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.BoardModel;
/*
 *   Spring 
 *   ======= Web ���̺귯�� 
 *    |
 *   Ŭ���� ���� => �޸� ���� ���� (���� = �Ҹ�) 
 *               ���ռ��� ���� ���α׷� => �ٸ� Ŭ������ ������ ��ġ�� �ʴ´� 
 *               ===============================================
 *                | ��������
 *               => ����� ���� 
 *                  === ��� ������ Ŭ������ �°� �ҽ� �ڵ�
 *                      ===> ������������ ��ӹ޴� ���� ���� �幰�� 
 *                      ===> POJO (2.5����) => �Ϲ� �ڹ� 
 *                      ===> �����̳� : �淮 / Ŭ����ȭ 
 *                           ======
 *                            ������ => ������ / �����۾� / ���콺 => ���� 
 *                      �б� / ���� / ����� / ���� => ������ 
 *                      ======================== �������� (�����밳��)
 *     1. ������Ʈ�� �´� Ŭ�������� 
 *     2. ���� => Ŭ������ Ŭ������ ���� ���踦 ���� : .xml , annotation 
 *     3. �ش� ��ġ���� ���۵� �޼ҵ� 
 *     ========================================================
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        BoardModel a=(BoardModel)app.getBean("board");
        a.list();
        
        
	}

}
