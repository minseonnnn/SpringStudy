package com.sist.dao;
import java.util.*;

import com.sist.vo.InputVO;
import com.sist.vo.StoreVO;

import java.sql.*;
public class GoodsDAO {
  private Connection conn;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
  
  public GoodsDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex){}
  }
  
  public void getConnection()
  {
	  try
	  {
	   	  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex) {}
  }
  public void disConnection()
  {
	  try
	  {
		  if(ps!=null) ps.close();
		  if(conn!=null) conn.close();
	  }catch(Exception ex) {}
  }
  
  public void insert(StoreVO svo,InputVO ivo)
  {
	  try
	  {
		  
		  getConnection();
		  conn.setAutoCommit(false); // around
		  String sql="INSERT INTO input VALUES(?,?,?)"; // 에러
		  ps=conn.prepareStatement(sql);
		  ps.setInt(1, ivo.getNo());
		  ps.setInt(2, ivo.getGno());
		  ps.setInt(3, ivo.getPrice());
		  ps.executeUpdate();
		  
		  sql="INSERT INTO store VALUES(?,?,?)"; // 에러
		  ps=conn.prepareStatement(sql);
		  ps.setInt(1, svo.getNo());
		  ps.setInt(2, svo.getGno());
		  ps.setInt(3, svo.getPrice());
		  ps.executeUpdate();
		  conn.commit(); // around
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
		  try
		  {
			  conn.rollback(); // 전체 SQL문장 취소 after-throwing
		  }catch(Exception e) {}
	  }
	  finally
	  {
		  try
		  {
			  conn.setAutoCommit(true); // 원상 복귀 after
		  }catch(Exception ex) {}
		  disConnection();
	  }
  }
}
