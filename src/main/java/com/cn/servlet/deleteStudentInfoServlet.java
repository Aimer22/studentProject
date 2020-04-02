package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/deleteStudentInfoServlet")
public class deleteStudentInfoServlet extends HttpServlet {
    StudentInfoService studentInfoService=new StudentInfoServiceImpl();
    StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int stuId = Integer.valueOf(request.getParameter("stuId"));
        StudentInfo studentInfo = studentInfoService.getStuInfoById(stuId);
        System.out.println(studentInfo);
        Student student = studentService.getStudentByNo(studentInfo.getStuNo());
        student.setIf_finished_firstStep(false);
        int recordNum1 = studentService.update(student);
        PrintWriter out = response.getWriter();
        if(recordNum1==1){
            int recordNum2 = studentInfoService.deleteStuInfo(stuId);
            if (recordNum2 ==1){
                out.write("<script>alert('删除成功！');"
                        +"window.location.href='getAllStudentServlet'</script>");
            }else{
                out.write("<script>alert('删除失败！');"
                        +"window.location.href='getAllStudentServlet'</script>");
            }
        }

    }
}
