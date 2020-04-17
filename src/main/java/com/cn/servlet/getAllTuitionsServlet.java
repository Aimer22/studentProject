package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.Tuition;
import com.cn.service.TuitionService;
import com.cn.service.impl.TuitionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/getAllTuitionsServlet")
public class getAllTuitionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



            List<Tuition> tuitionList= new ArrayList<Tuition>();
            TuitionService tuitionService=new TuitionServiceImpl();
            List<Tuition> tuitions=tuitionService.getAllTuition();
            for (Tuition tuition :tuitions){
                if (tuition.isStateOfPay()){
                    tuitionList.add(tuition);
                }
            }

            request.setAttribute("tuitionList",tuitionList);
            request.getRequestDispatcher("jsp/admins/getAllTuitions.jsp").forward(request,response);


    }
}
