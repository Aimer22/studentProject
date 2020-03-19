package com.cn.servlet;

import com.cn.domain.*;
import com.cn.service.DormService;
import com.cn.service.StuClassService;
import com.cn.service.StudentInfoService;
import com.cn.service.TuitionService;
import com.cn.service.impl.DormServiceImpl;
import com.cn.service.impl.StuClassServiceImpl;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.TuitionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class registStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取登录用户信息
        Student student = (Student) request.getSession().getAttribute("student");
        StudentInfoService stu = new StudentInfoServiceImpl();
        StudentInfo studentInfo = stu.getStuInfoByNo(student.getStuNo());
        TuitionService ts = new TuitionServiceImpl();
        Tuition tuition = ts.getTuitionBystuNo(student.getStuNo());

        request.setAttribute("studentInfo",studentInfo);
        request.setAttribute("tuition",tuition);

        boolean first = student.isIf_finished_firstStep();
        boolean second = student.isIf_finished_secondStep();
        PrintWriter out = response.getWriter();
        //检测是否完成注册
        if (first==true&&second==true){
            request.getRequestDispatcher("jsp/users/students/finishedRegist.jsp").forward(request,response);
        }else if (first==true&&second==false){

            request.getRequestDispatcher("jsp/users/students/secondStep.jsp").forward(request,response);

        }else {
            request.getRequestDispatcher("jsp/users/students/startToRegist.jsp").forward(request,response);
        }

    }
}
