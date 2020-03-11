package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class getAllStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        List<StudentInfo> studentInfos=studentInfoService.getAllStuInfo();
        req.setAttribute("studentInfos",studentInfos);
        req.getRequestDispatcher("jsp/admins/getAllStudent.jsp").forward(req,resp);

        }

        }
