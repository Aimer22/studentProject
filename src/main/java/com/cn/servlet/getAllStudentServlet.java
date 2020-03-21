package com.cn.servlet;

import com.cn.domain.ShowStuInfo;
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
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        List<ShowStuInfo> showStuInfos=studentInfoService.showAllStuInfo();
//        QueryRunnerDemo qr = new QueryRunnerDemo();
//        List<Map<String,Object>> showStuInfos = null;
//        System.out.println(showStuInfos);
//        try {
//            showStuInfos = qr.select();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        req.setAttribute("showStuInfos",showStuInfos);
        req.getRequestDispatcher("jsp/admins/getAllStudent.jsp").forward(req,resp);

        }

        }
