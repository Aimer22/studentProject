package com.cn.service;

import com.cn.domain.StuClass;

import java.util.List;

public interface StuClassService {

    int addStuClass(StuClass stuClass);

    int deleteClass(String class_Id);

    int updateClass(StuClass stuClass);

    List<StuClass> getAllClass();

    StuClass getClassById(String class_Id);
}
