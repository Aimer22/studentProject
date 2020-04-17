package com.cn.servlet;

import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getStuInfoByDormServlet")
public class getStuInfoByDormServlet extends HttpServlet {
    private StudentInfoService studentInfoService = new StudentInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String dorm_Num = request.getParameter("dorm_Num");
            List<StudentInfo> studentInfos = studentInfoService.getAllStuInfo(); //获取所有学生信息
            List<StudentInfo> studentInfos1 = new ArrayList<StudentInfo>();
            for (StudentInfo studentInfo : studentInfos){   //遍历所有学生信息
                if(dorm_Num.equals(studentInfo.getDorm())){
                    studentInfos1.add(studentInfo);            //如果宿舍号相同则加入列表
                }
            }

            request.setAttribute("studentInfoList",studentInfos1);
            request.getRequestDispatcher("jsp/admins/getStudentInfoByClass.jsp").forward(request,response);

    }
}
