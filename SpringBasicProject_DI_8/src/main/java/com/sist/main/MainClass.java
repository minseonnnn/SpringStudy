package com.sist.main;
/*
 *    ������ : �ε����� ���� 
 *            ���¼ҽ� ���̺귯�� => Ȯ�强 (�����ؼ� ����� ����) 
 *            ===============
 *              �������������ӿ�ũ (�����) ***
 *              �ִ������ӿ�ũ (����) 
 *              �Ϲ� ������ (������)
 *    �������� �����ϴ� ���̺귯�� 
 *    =====================
 *    1. core : ��ü ���� ~ ��ü �Ҹ� , ��ü ���� 
 *              ---------------------------
 *                ��ü �����ֱ� => �����̳� (�淮 �����̳�) => Ŭ���� ������ 
 *                ========== DI
 *    2. aop : ���� ����� ��Ƽ� �ڵ����� ó�� 
 *       ==== oop�� ������ ���α׷� 
 *           ===== ��ü�������α׷� (���� : OOP)
 *    3. Data Access : JDBC / ORM / OXM / JMS 
 *                                        ==== Message Service
 *                           =====  === XML�Ľ� 
 *                            MyBatis / Hibernate / JPA
 *    4. WEB : MVC
 *    ��Ÿ : Spring Data (������ �м�) 
 *          *** Spring Security 
 *          Spring Cloud (MSA)
 *          Spring AI
 *          => ������ƽ��ġ 
 *             ========= �˻� ���� => ��� => ���� 
 *    
 *      1) DI�� ��� �������� �⺻ => �ʼ� ���� 
 *         == ������ : Ŭ���� ������ (����~�Ҹ�)
 *            => ���α׷��� �°� Ŭ������ �����Ѵ� 
 *            => �ٸ� �����ӿ�ũ�� ȣȯ���� ���� 
 *            => �ٷ� �Ⱦ �� �ִ�
 *            => XML ��� / Annotation ��� (�����ϰ� �ڹٷ�) 
 *               =======   ============================
 *               Spring 4  Spring 5
 *                         ========= ���� (.class) 
 *         DI => Ŭ���� �����ؼ� �����ϴ� �����̳� Ŭ����
 *               ===============================
 *                   ���������� �����ϴ� �����̳� (Ŭ���� 1�� : ������Ʈ/��)
 *                        BeanFactory : core(DI) 
 *                            |
 *                     ApplicationContext : core(DI),AOP
 *                     ==============================
 *                     |                |
 *                                 AnnotationConfigApplicationContext
 *                                    => �ڹٷ� ȯ�� ����
 *               GenericXmlApplicationContext
 *                => GC => close()
 *                            |
 *                   WebApplicationContext : core(DI),AOP,MVC
 *                ***  ���� : DI/AOP/Transaction
 *                     === SI
 *                *** �ڵ��׽�Ʈ : �ڹٽ�ũ��Ʈ => �ַ�� 
 *                *** AWS : ������ ��ɾ� 
 *          �����̳�(������) : Ŭ������ ���� ��� / ���� ���谡 ���� ��쿡 �ַ� ��� 
 *                         =================================
 *                          �� / ���� 
 *              |
 *               XML��� =======> ������ (�����ͺ��̽� ����) 
 *               ������̼� ��� ==> ����� ���� (������ ����)
 *         
 *         ������ �����ӿ�ũ�� Ư¡ 
 *         1. �淮 �����̳� => DI + DL 
 *            ==========
 *             1) ��ü ���� => DI
 *                <bean id="" class="">
 *             2) ��ü ã�� 
 *                getBean("id")  => DL
 *             3) ��ü �Ҹ� 
 *         2. POJO����� ����Ѵ� : Spring 2.5 => ���� 
 *            ===== ��� , �������̽� �������� �����ϰ� �ڹٷθ� ����ϴ� �Ϲ� Ŭ���� 
 *                 =============== �����Ӱ� ���� (�ٸ� Ŭ������ ������ ����) 
 *              | �������� ���ÿ� ���߽ÿ� ���θ� ����...
 *              | ���� ��� : ���� / 1�� => ���� ó���� ���ϱ� ������ ...
 *              | GPT 
 *            => Ư�� �����ӿ�ũ ����� �������� �ʴ´� 
 *            => ���ռ��� ���� ���α׷� ���� 
 *         3. ���������� ���ϴ� : Ŭ������ ���������� ���� 
 *         4. Ȯ�强 
 *         5. �ʿ��� ��� ���̺귯���� �����Ѵ� 
 *         
 *      ===============================================
 *      �Թ� 
 *       DI / AOP / DataBase / MVC 
 *       => ��°��� ���� 
 *       
 *        
 *      DI 
 *      === 1) setter DI : setXxx() => ������ �ʱ�ȭ 
 *      === 2) ������ DI : 
 *      === 3) �޼ҵ� DI 
 *                = ��ü ������ 
 *                = ��ü �Ҹ�� 
 *      === Ŭ������ Ŭ������ ���� ���� ���� => �޴��� ���� 
 *                                       ========= ���� 
 *                                       => XML (application.xml)
 *      1. XML ��� 
 *      2. Annotation 
 *      ============== �������� 
 *      3. �ڹ� ���  : ������ ���� ===> Spring Framework (X) ==> Spring-Boot
 *            
 *      *** ���������� Ŭ���� ��� 
 *          ================= ��� Ŭ���� ��� (VO�� ����)
 *                                          === ����� ���� �������� 
 *          Ŭ���� ��� 
 *          ========
 *          1) XML 
 *             = <bean id="" class=""> : �Ѱ��� Ŭ������ ���
 *             = <context:component-scan basepackage="">
 *               => ������ 
 *               => ��ϵ� Ŭ������ �ݵ�� ������̼��� ��� 
 *                  =  @Component  : �Ϲ� Ŭ���� 
 *                  =  @Repository : DAO (�����)
 *                  =  @Service    : BI => ��� ���� 
 *                  =  @Controller : Model => forward / redirect
 *                  =  @RestController : Model => void : ajax
 *                        JSON : �ڹٽ�ũ��Ʈ ���� 
 *                        ==== Vue , React 
 *                        ==== simple-json (X) 
 *                        ==== jackson
 *                  =  @ControllerAdvice : ���� ����ó�� 
 *              = @Bean : xml���� ó��
 *           2) DI 
 *              XML������ ����� ���� : ��������� �ʱ�ȭ 
 *              ================= setter DI / ������ DI 
 *              class A
 *              {
 *                  private int a,b;
 *                  public void setA(int a)
 *                  {
 *                     this.a=a;
 *                  }
 *                  public void setB(int b)
 *                  {
 *                     this.b=b;
 *                  }
 *                  public A(int a,int b)
 *                  {
 *                     this.a=a;
 *                     this.b=b;
 *                  }
 *              } 
 *              
 *              <bean id="aa" class="A"
 *                p:a="10" ==> setA(10)
 *                ==== setter
 *                p:b="20" ==> setB(20)
 *                c:a="100" c:b="200" ==> A(100,200)
 *                ==== ������
 *              />
 *              
 *              p:name="aaa" => �Ϲ� ���� 
 *              p:name-ref="id��" ==> Ŭ���� ��ü => id�� 
 *              
 *        1. XML�̿��ϴ� ��� 
 *        2. ������̼� 
 *        3. XML+Annotation (���� ���� ���) 
 *        
 *           => ���̺귯�� Ŭ���� ��� : MyBatis , MVC , Security 
 *              ======== ������̼��� ���� (XML���) 
 *           => ����� ���Ǵ� ������̼��� �ַ� ��� 
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �����̳ʿ� ��� 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
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
