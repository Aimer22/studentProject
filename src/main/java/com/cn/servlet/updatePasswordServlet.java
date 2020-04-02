package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePasswordServlet")
public class updatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("student");

        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        System.out.println(old_password);
        System.out.println(new_password);
        System.out.println(student.getPassword());
        System.out.println(old_password.equals(student.getPassword()));
        if (old_password.equals(student.getPassword())){
            System.out.println("正在修改密码... ...");
            student.setPassword(new_password);
            StudentService studentService = new StudentServiceImpl();
            studentService.update(student);
            request.getRequestDispatcher("jsp/users/students/updatePassword.jsp").forward(request,response);

        }else {
            System.out.println("...");
            PrintWriter out = response.getWriter();
            out.write("<script>alert('您的初始密码有误，请重新输入');"
                    +"window.location.href='jsp/users/students/updatePassword.jsp'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        if (student!=null){
            request.getRequestDispatcher("jsp/users/students/updatePassword.jsp").forward(request,response);
        }else {
            out.write("<script>alert('请先登录');"
                    +"window.location.href='jsp/newLogin.jsp'</script>");
        }
    }
}
