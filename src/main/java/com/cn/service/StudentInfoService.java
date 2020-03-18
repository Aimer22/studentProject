package com.cn.service;




import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;

import java.sql.SQLException;
import java.util.List;

public interface StudentInfoService {
    int addStudentInfo(StudentInfo studentInfo) throws SQLException;

    int deleteStuInfo(int stuId);

    int updateStuInfo(StudentInfo studentInfo);

    List<StudentInfo> getAllStuInfo();

    List<ShowStuInfo> showAllStuInfo();

    StudentInfo getStuInfoById(int stuId);

    StudentInfo getStuInfoByNo(int stuNo);



}
