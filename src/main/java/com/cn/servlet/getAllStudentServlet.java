package com.cn.servlet;

import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAllStudentServlet")
public class getAllStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        List<StudentInfo> studentInfos=studentInfoService.getAllStuInfo();

//        }
        req.setAttribute("studentInfos",studentInfos);
        req.getRequestDispatcher("jsp/admins/getAllStudent.jsp").forward(req,resp);

        }

        }
