package com.cn.dao;




import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface StudentInfoDao {
		
	int addStudentInfo(StudentInfo studentInfo) throws SQLException;
	
	int deleteStudentInfo(int stuId) throws SQLException;
	
	int update(StudentInfo studentInfo) throws SQLException;
	
	List<StudentInfo> getAllStudentInfo() throws SQLException;
	
	StudentInfo getStuInfoByStuId(int stuId) throws SQLException;
	
	StudentInfo getStuInfoByStuNo(int stuNo) throws SQLException;

	List<ShowStuInfo> ShowAllStuInfo() throws SQLException;

}
