package com.cn.servlet;

import com.cn.domain.Dorm;
import com.cn.service.DormService;
import com.cn.service.impl.DormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/getAllDormsServlet")
public class getAllDormsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DormService dormService=new DormServiceImpl();
        List<Dorm> dorms=dormService.getAllDorm();
        System.out.println(dorms);

        request.setAttribute("dorms",dorms);
        request.getRequestDispatcher("jsp/admins/getAllDorms.jsp").forward(request,response);

    }
}
