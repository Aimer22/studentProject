package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.domain.Tuition;
import com.cn.service.StudentInfoService;
import com.cn.service.TuitionService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.TuitionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getPayInfoServlet")
public class getPayInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("student");

        PrintWriter out = response.getWriter();

        if (student!=null){
            TuitionService tuitionService = new TuitionServiceImpl();
            StudentInfoService studentInfoService = new StudentInfoServiceImpl();
            StudentInfo studentInfo = studentInfoService.getStuInfoByNo(student.getStuNo());
            Tuition tuition = tuitionService.getTuitionBystuNo(student.getStuNo());
            request.setAttribute("tuition",tuition);
            request.setAttribute("studentInfo",studentInfo);

            request.getRequestDispatcher("jsp/users/students/getPayInfo.jsp").forward(request,response);
        }else {
            out.write("<script>alert('请先登录');"
                    +"window.location.href='jsp/newLogin.jsp'</script>");
        }



    }
}
