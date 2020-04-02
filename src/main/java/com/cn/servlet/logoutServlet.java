package com.cn.servlet;

import com.cn.domain.Admin;
import com.cn.domain.Student;
import com.cn.service.AdminService;
import com.cn.service.StudentService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private AdminService adminService = new AdminServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取账户信息
        Student student = (Student) request.getSession().getAttribute("student");
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        PrintWriter out = response.getWriter();


        if (student!=null){
            student.setIfUse(false);
            studentService.update(student);
            request.getSession().removeAttribute("student");
            response.sendRedirect("jsp/newLogin.jsp");
        }else {
            out.write("<script>alert('请先登录');"
                    +"window.location.href='jsp/newLogin.jsp'</script>");
        }


        if (admin != null){
            admin.setIfUse(false);
            adminService.updateAdmin(admin);
            request.getSession().removeAttribute("admin");
            response.sendRedirect("jsp/newLogin.jsp");
        }else {
            out.write("<script>alert('请先登录');"
                    +"window.location.href='jsp/newLogin.jsp'</script>");
        }



    }
}
