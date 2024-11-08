package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

import lombok.Setter;
public interface EmpMapper {
  @Select("SELECT empno,ename,job,hiredate,sal "
		 +"FROM emp ORDER BY empno ASC")
  public List<EmpVO> empListData(); // 자동 구현이 된다 
  // 반환도 자동화 
  //     resultType      id     parameterType
  // <select id="empListData" resultType="EmpVO" parameterType="">
}
