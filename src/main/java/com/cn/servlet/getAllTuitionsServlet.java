package com.cn.servlet;

import com.cn.domain.Tuition;
import com.cn.service.TuitionService;
import com.cn.service.impl.TuitionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/getAllTuitionsServlet")
public class getAllTuitionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        TuitionService tuitionService=new TuitionServiceImpl();
        List<Tuition> tuitions=tuitionService.getAllTuition();

        request.setAttribute("tuitions",tuitions);
        request.getRequestDispatcher("jsp/admins/getAllTuitions.jsp").forward(request,response);
    }
}
