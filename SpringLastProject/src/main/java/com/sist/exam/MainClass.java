package com.sist.exam;
import java.util.*;

import com.sist.vo.SeoulVO;

import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* try
        {
        	String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
        	String user="root";
        	String password="happy";
        	String driver="com.mysql.cj.jdbc.Driver";
        	
        	Scanner scan=new Scanner(System.in);
        	System.out.println("페이지 입력:");
        	int page=scan.nextInt();
        	
        	int rowSize=10;
        	int start=(rowSize*page)-rowSize;
        	
        	Class.forName(driver);
        	Connection conn=DriverManager.getConnection(url,user,password);
        	String sql="SELECT title FROM project_seoul_location "
        			  +"ORDER BY no ASC "
        			  +"LIMIT "+start+",10";
        	PreparedStatement ps=conn.prepareStatement(sql);
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		System.out.println(rs.getString(1));
        	}
        	ps.close();
        	conn.close();
        }catch(Exception ex) {}*/
		Scanner scan=new Scanner(System.in);
		// malloc(클래스) => 크기 확인 => free() 
		int totalpage=SeoulDAO.seoulTotalPage();
		System.out.println("페이지 입력:(1~"+totalpage+")");
		int page=scan.nextInt();
		
		int start=(page*10)-10;
		
		List<SeoulVO> list=SeoulDAO.seoulListData(start);
		
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getTitle());
			System.out.println(vo.getAddress());
			System.out.println("=============================================================");
		}
	}

}
