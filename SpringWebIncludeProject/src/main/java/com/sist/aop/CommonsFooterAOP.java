package com.sist.aop;

import org.apache.commons.fileupload.RequestContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*
 *    1. 스프링 = 프레임워크
 *       = 라이브러리 : 자주 사용되는 기능을 모아서 미리 구현한 클래스의 집합
 *                                      ==============
 *                   개발자마다 다르게 구현 ...
 *                   = 레고
 *       = 프레임워크 : 미리 구현된 클래스의 집합 
 *                   기본 틀이 만들어져 있다 
 *                   ====== 기본 틀에 맞게 구현 
 *                          =====
 *                          Controller => @GetMapping , @PostMapping
 *                          | 개발자마다 형식이 동일하게 구현
 *                          | 조립식
 *                          | 스프링 => 메인 보드
 *         *** 개발자의 수준과 실력에 상관 없이 일정 수준의 개발이 가능
 *         *** 초보자도 많은 시간을 투자할 필요가 없이 유지보수가 가능
 *         *** 무료 => 개발기간을 단출 , MVC는 이미 제작 => 기능만 구현
 *         *** 많은 기능을 가지고 있다 = 학습하기가 약간 시간이 걸린다    
 *         *** 프로그램이 무겁다 => 속도가 저하
 *     1. 스프링의 기본 기능
 *        = DI
 *          클래스를 모아서 관리하는 목적 (객체의 생명 주기 관리)
 *          ---------------------
 *            메모리 할당 (new 대체) => 생성
 *                                 ====
 *                                  필요한 경우에는 멤버변수의 초기화가 가능
 *                                             ============
 *                                             1) setter DI
 *                                                p: ~
 *                                             2) 생성자 DI 
 *                                                c: ~
 *                              => 소멸
 *             => 관리하는 클래스 : VO를 제외 , 인터페이스 : 생성이 불가능
 *                             ======== 사용자 정의 데이터형
 *                클래스 한개에 대한 관리 요청
 *                => <bean id="" class=""/>
 *                패키지 단위로 관리
 *                => <component-scan base-package="패키지명">          
 *                    => 선택
 *                    => 클래스마다 구분
 *                       @Component : 일반 클래스 => MainClass.Jsoup ..
 *                       @Repository : DAO
 *                       @Service : DAO 여러개 등록 => BI
 *                       @Controller : Model (요청 처리) => 화면 제어
 *                       @RestController : Model (요청 처리) => 데이터를 전송
 *                                                           ==========
 *                                                           | Vue, Ajax
 *                       @ControllerAdvice : 공통 예외처리                     
 *        = AOP : 프로그램 개발 => 소스가 중복 , 공통 기능 
 *                             => 소스 중복 제거 , 공통으로 적용 => 자동화 처리
 *                             => 어떤 메소드에 어떤 위치에 이 기능을 수행
 *                                ========  =======
 *                                |PointCut |JoinPoint
 *                   public void aaa(){} => before            
 *                   public void bbb(){} => after-throwing            
 *                   public void ccc(){} => after             
 *                   public void ddd(){} => after-returning   
 *                   
 *                   public void display_1()
 *                   {
 *                     try
 *                     {
 *                         aaa() => before
 *                     }catch(Exception e)
 *                     {
 *                         bbb() => after-throwing
 *                     }
 *                     finally
 *                     {
 *                         ccc()
 *                     }
 *                     
 *                     return ddd()
 *                   }
 *                   public void display_2()
 *                   {
 *                     try
 *                     {
 *                         aaa()
 *                     }catch(Exception e)
 *                     {
 *                         bbb()
 *                     }
 *                     finally
 *                     {
 *                         ccc()
 *                     }
 *                     
 *                     return ddd()
 *                   }
 *                   public void display_3()
 *                   {
 *                     try
 *                     {
 *                         aaa()
 *                     }catch(Exception e)
 *                     {
 *                         bbb()
 *                     }
 *                     finally
 *                     {
 *                         ccc()
 *                     }
 *                     
 *                     return ddd()
 *                   }
 *        = MVC
 *              브라우저 요청 (URL 주소 이용)
 *                         ==> *.do (요청 받기)     @GetMapping/@PostMapping에서 해당 URL을 찾는다
 *                                                                     return 값을 받아서 JSP를 찾는다 
 *          클라이언트 ====== DispatcherServlet ==== HandelerMapping ==== ViewResolver ==== JSP
 *                                                                                        | 화면 출력 
 *                                                       |
 *                                                     요청 처리
 *                                                   @Controller => Model
 *                                                   =========== 오라클에서 데이터를 읽어 온다
 *                                                        |
 *                                                   1) 요청 값을 받는다 : request를 이용
 *                                                                    매개변수를 이용 (권장)
 *                                                   2) DB변동
 *                                                      서비스 계층 === 데이터 엑세스 계층            
 *                                                      --------     -------------
 *                                                   3) 결과값 전송            
 *        = 데이터베이스 : ORM (MyBatis)              
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.service.*;
import com.sist.vo.*;
@Aspect // 공통모듈 => 반복 제거 => 메모리 할당이 아니다  
@Component // 메모리 할당
public class CommonsFooterAOP {
   @Autowired
   private RecipeService rService;
   // 수행되는 위치 => finally{메소드 수행} => 오류와 상관없이 무조건 수행 
   @After("execution(* com.sist.web.*Controller.*(..))")
   public void commonsFooterData()
   {
	   List<FoodVO> foodList=rService.foodTop5Data();
	   List<RecipeVO> recipeList=rService.recipeTop5Data();
	   
	   // 전송 => request
	   HttpServletRequest request=((ServletRequestAttributes)
			   RequestContextHolder.getRequestAttributes()).getRequest();
	   request.setAttribute("foodList", foodList);
	   request.setAttribute("recipeList", recipeList);
   }
}
