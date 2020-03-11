package com.cn.service;


import com.cn.domain.Student;

import java.util.List;

public interface StudentService {
	int add(Student student);
	
	int delete(int stuNo);
	
	int update(Student student);
	
	List<Student> getAll();
	
	Student getStudentByNo(int stuNo);
	
	Student getStudentByName(String stuName);
	
	Student getStudentByUserName(String username);
}
