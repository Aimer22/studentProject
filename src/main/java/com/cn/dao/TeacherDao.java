package com.cn.dao;





import com.cn.domain.Teacher;

import java.sql.SQLException;
import java.util.List;


public interface TeacherDao {
	int addTeacher(Teacher teacher) throws SQLException;
	
	int deleteTeacher(Integer teaNo) throws SQLException;
	
	int updateTeacher(Teacher teacher) throws SQLException;
	
	List<Teacher> getAllTeacher() throws SQLException;
	
	Teacher getTeacherById(Integer teaNo) throws SQLException;
	
	Teacher getTeacherByName(String teaName) throws SQLException;
	
	Teacher getTeacherByUserName(String userName) throws SQLException;
	
}
