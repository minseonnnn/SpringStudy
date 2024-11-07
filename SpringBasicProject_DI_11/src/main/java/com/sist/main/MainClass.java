package com.sist.main;
/*
 *   maven => ant 
 *     |
 *    1) ���̺귯�� ���� : pom.xml 
 *    2) ������Ʈ ���� => ���� ���� 
 *    3) ���� ���� => �ڵ����� war(��)
 *                  ============== war => ���� AWS�ü���� ���� => tomcat
 *       AWS : �ü���� ������ ��� 
 *             ====== ������ ��ġ : ���� IP�� ���� ���� 
 *             
 *    ������ : DI / AOP (�����ľ�) / MVC / MyBatis (ORM)  => security / websocket
 *                                      | Transaction 
 *                               | ���ͼ�Ʈ 
 *                               ====================
 *           ================================================================
 *              Base : DI 
 *              
 *   => DI 
 *      1) Ŭ���� ��� 
 *         = <bean id="" class=""> �Ѱ��� Ŭ���� ��� 
 *         = ***<context:component-scan basepackage=""> ������ Ŭ������ ���ÿ� �޸� �Ҵ� 
 *           �ݵ�� �޸� �Ҵ��� Ŭ������ ���� 
 *           class���� ������̼��� �̿��ؼ� ���� 
 *           => Ŭ���� �������� ����
 *              �Ϲ� Ŭ���� : @Component => MainClass ... ~Manager
 *              �����ͺ��̽� ���� : @Repository => ~DAO
 *              ���õ� DAO�� ���� : @Service
 *              Model Ŭ���� : @Controller / @RestController 
 *                                          | ȭ�� ��� �ƴ϶� => �ڹٽ�ũ��Ʈ,��Ʋ�� ����
 *                                            => JSON
 *                                            => RestFul
 *                                               =======
 *                                               �ٸ� ���� ���� : CRUD
 *                                               => GET : SELECT 
 *                                               => POST : INSERT
 *                                               => PUT : UPDATE
 *                                               => DELETE : DELETE
 *                                               ===================
 *                            |�Ϲ� JSP���� 
 *                             => forward/redirect
 *                ���� ����ó�� : @ControllerAdvice
 *         = XML���� ��� 
 *           => @Bean => �ڹٷθ� �ڵ��ϴ� ��� 
 *         
 *         ** �������� �����̳ʴ� (Ŭ���� ������) => MVC�� �������� �Ϻ� ���̺귯�� (�ַ�)
 *                   ====== Ŭ������ ��Ƽ� ���� 
 *                                      ==== ��ü ���� ~ ��ü �Ҹ� (��ü�� �����ֱ� ���)
 *                                           =======
 *                                           = ������� �ʱ�ȭ => DI
 *                                             ===========
 *                                             1. setter : setXxx(����)
 *                                                p:name => setName()
 *                                             2. ������ �̿� 
 *                                                c:name => ������(String name)
 *                                           =================================
 *                                            => ��������� Ŭ���������� ���󵵰� ���� ���� 
 *                                            => �����ͺ��̽� ���� : ����Ŭ ������ ���۰� ���ÿ� ���� 
 *        ** �����ڰ� ���� ���� 
 *           ==============
 *            1) �� ���� : �Ѱ��� ���� ��� 
 *                          XML + Java  => Java
 *            2) ���� ������ ��ƴ� 
 *                          XML�� ������ �ִ� (X) => Java 
 *                                                ==== ������ .class
 *            =================== ������ 5 �������� ���� 
 *            => ���� ���α׷��� ���� : ȣȯ�� 
 *            => ������ 6 => javax => jakarata
 *   
 *      MyBatis : @Select....
 *                �Ű������� �ݵ�� 1�� 
 *                ================= ������ ��뵵 ���� (����)
 *                ������ SQL���� => �������� 
 *                =====================
 *                => XML => ������̼����� ���� 
 *                => PROCEDURE / TRIGGER => ��� SQL
 *                => 2�� ������Ʈ : �Ի��Ŀ� �ٷ� ���� (�ǹ�)
 *      
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        EmpDAO2 dao=(EmpDAO2)app.getBean("dao");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getDbday()+" "
        			+vo.getSal());
        }
	}

}
