package com.cn.service;




import com.cn.domain.StudentInfo;

import java.sql.SQLException;
import java.util.List;

public interface StudentInfoService {
    int addStudentInfo(StudentInfo studentInfo) throws SQLException;

    int deleteStuInfo(String stuId);

    int updateStuInfo(StudentInfo studentInfo);

    List<StudentInfo> getAllStuInfo();

    StudentInfo getStuInfoById(String stuId);

    StudentInfo getStuInfoByName(String name);

}
