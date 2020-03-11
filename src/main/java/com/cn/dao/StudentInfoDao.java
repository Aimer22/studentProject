package com.cn.dao;




import com.cn.domain.StudentInfo;

import java.sql.SQLException;
import java.util.List;


public interface StudentInfoDao {
		
	int addStudentInfo(StudentInfo studentInfo) throws SQLException;
	
	int deleteStudentInfo(String stuId) throws SQLException;
	
	int update(StudentInfo studentInfo) throws SQLException;
	
	List<StudentInfo> getAllStudentInfo() throws SQLException;
	
	StudentInfo getStuInfoByStuId(String stuId) throws SQLException;
	
	StudentInfo getStuInfoByStuName(String stuName) throws SQLException;

}
