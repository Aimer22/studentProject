package com.cn.servlet;

import com.cn.domain.StuClass;
import com.cn.service.StuClassService;
import com.cn.service.impl.StuClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/getAllClassServlet")
public class getAllClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        StuClassService stuClassService = new StuClassServiceImpl();
        List<StuClass> stuClasses = stuClassService.getAllClass();

        request.setAttribute("stuClasses",stuClasses);
        request.getRequestDispatcher("jsp/admins/getAllClass.jsp").forward(request,response);
    }
}
