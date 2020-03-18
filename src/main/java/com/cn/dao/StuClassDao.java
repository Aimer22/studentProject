package com.cn.dao;

import com.cn.domain.StuClass;

import java.sql.SQLException;
import java.util.List;


/*
* 用户的持久层接口
* */
public interface StuClassDao {
    int addStuClass(StuClass stuClass) throws SQLException;

    int deleteClass(String class_Id) throws SQLException;

    int updateClass(StuClass stuClass) throws SQLException;

    List<StuClass> getAllClass() throws SQLException;

    StuClass getClassById(String class_Id) throws SQLException;

//    List<StuClass> getAllClassByName(String name) throws SQLException;

//    List<StuClass> getAllClassByCondition(StuClass stuClass) throws SQLException;
}
