package com.cn.servlet;

import com.cn.domain.Teacher;
import com.cn.service.TeacherService;
import com.cn.service.impl.TeacherServiveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/getAllTeachersServlet")
public class getAllTeachersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherService teacherService=new TeacherServiveImpl();
        List<Teacher> teachers=teacherService.getAllTeacher();
        request.setAttribute("teachers",teachers);
        request.getRequestDispatcher("jsp/admins/getAllTeachers.jsp").forward(request,response);
    }
}
