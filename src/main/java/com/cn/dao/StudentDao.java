package com.cn.dao;




import com.cn.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    int add(Student student) throws SQLException;

    int delete(int stuNo) throws SQLException;

    int update(Student student) throws SQLException;

    List<Student> getAll() throws SQLException;

    Student getStudentBystuNo(int stuNo) throws SQLException;

    Student getStudentByName(String stuName) throws SQLException;

    Student getStudentByUserName(String username) throws SQLException;
}
