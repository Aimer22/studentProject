package com.cn.servlet;

import com.cn.domain.Student;

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
