package com.cn.service;




import com.cn.domain.Teacher;

import java.util.List;

public interface TeacherService {
	int addTeacher(Teacher teacher);
	
	int deleteTeacher(Integer teaId);
	
	int updateTeacher(Teacher teacher);
	
	List<Teacher> getAllTeacher();
	
	Teacher getTeacherById(Integer teaId);
	
	Teacher getTeacherByName(String teaName);
	
	Teacher getTeacherByUserName(String userName);
}
