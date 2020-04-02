package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getClassInfoServlet")
public class getClassInfoServlet extends HttpServlet {
    private List<Student> students = new ArrayList<Student>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String class_Id = request.getParameter("class_Id");
        StudentInfoService studentInfoService = new StudentInfoServiceImpl();

        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        List<StudentInfo> studentInfos = studentInfoService.getAllStuInfo();
        for (StudentInfo studentInfo : studentInfos){
            if (class_Id.equals(studentInfo.getStuClass())){
                studentInfoList.add(studentInfo);
            }
        }

        /*for (StudentInfo studentInfo : studentInfoList){
            System.out.println("拿到了哈哈"+studentInfo);
        }*/
        request.setAttribute("studentInfoList",studentInfoList);
        request.getRequestDispatcher("jsp/admins/getStudentInfoByClass.jsp").forward(request,response);

    }
}
