package com.cn.servlet;

import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteStudentInfoServlet extends HttpServlet {
    StudentInfoService studentInfoService=new StudentInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        int recordNum=studentInfoService.deleteStuInfo(request.getParameter("stuId"));
        System.out.println("正在删除。。。");
        PrintWriter out = response.getWriter();
        if(recordNum==1){
            out.write("<script>alert('删除成功！')"
                    +"window.location.href='getAllStudentServlet'</script>");
        }else{
            out.write("<script>alert('删除失败！')"
                    +"window.location.href='getAllStudentServlet'</script>");
        }

    }
}
