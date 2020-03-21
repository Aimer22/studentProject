package com.cn.servlet;

import com.cn.domain.*;
import com.cn.service.DormService;
import com.cn.service.StuClassService;
import com.cn.service.StudentInfoService;
import com.cn.service.TuitionService;
import com.cn.service.impl.DormServiceImpl;
import com.cn.service.impl.StuClassServiceImpl;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.TuitionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/registStateServlet")
public class registStateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        System.out.println(student);
        if (student!=null){
            //获取登录用户信息
            request.setAttribute("student",student);

            boolean first = student.isIf_finished_firstStep();
            boolean second = student.isIf_finished_secondStep();

            //检测是否完成注册
            if (first==true&&second==true){

                request.getRequestDispatcher("jsp/users/students/registSucceed.jsp").forward(request,response);
            }else if (first==true&&second==false){

                request.getRequestDispatcher("jsp/users/students/secondStep.jsp").forward(request,response);

            }else {
                request.getRequestDispatcher("jsp/users/students/registState.jsp").forward(request,response);
            }
        }else {
            out.write("<script>alert('请先登录');"
                    +"window.location.href='jsp/newLogin.jsp'</script>");
        }



    }
}
