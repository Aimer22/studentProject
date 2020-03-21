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
import java.io.PrintWriter;


@WebServlet("/addDormServlet")
public class addDormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取数据
        String Dorm_Num=request.getParameter("dorm_num");
        String Dorm_Sex=request.getParameter("dorm_sex");
        System.out.println(Dorm_Num);
        System.out.println(Dorm_Sex);
        int Max_Num=Integer.parseInt(request.getParameter("max_num"));
        System.out.println(Max_Num);

        //封装数据
        DormService dormService=new DormServiceImpl();
        Dorm dorm = new Dorm();
        dorm.setDorm_Num(Dorm_Num);
        dorm.setDorm_Sex(Dorm_Sex);
        dorm.setAllStu(Max_Num);

        int recordNum=dormService.addDorm(dorm);
        PrintWriter out=response.getWriter();
        if(recordNum==1) {
            out.write("<script>alert('添加成功！');"+"window.close();window.location.href='getAllDormsServlet'</script>");
        }else {
            out.write("<script>alert('很抱歉，添加失败。');"+"window.close();window.location.href='getAllDormsServlet'</script>");
        }
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
