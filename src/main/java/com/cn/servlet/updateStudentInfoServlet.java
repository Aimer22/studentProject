package com.cn.servlet;


import com.cn.domain.Dorm;
import com.cn.domain.StuClass;
import com.cn.domain.StudentInfo;
import com.cn.service.DormService;
import com.cn.service.StuClassService;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.DormServiceImpl;
import com.cn.service.impl.StuClassServiceImpl;
import com.cn.service.impl.StudentInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/updateStudentInfoServlet")
public class updateStudentInfoServlet extends HttpServlet {
    StudentInfoService studentInfoService=new StudentInfoServiceImpl();
    StudentInfo studentInfo=new StudentInfo();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 请求数据，并将数据进行封装
        studentInfo.setSex(request.getParameter("sex"));
        studentInfo.setAge(Integer.valueOf(request.getParameter("age")));
        studentInfo.setBirthPlace(request.getParameter("home"));
        studentInfo.setCampus(request.getParameter("campus"));
        studentInfo.setMajor(request.getParameter("major"));
        studentInfo.setNational(request.getParameter("national"));
        studentInfo.setStuClass(request.getParameter("stuClass"));
        studentInfo.setDorm(request.getParameter("dorm"));
        studentInfo.setPhone(request.getParameter("phone"));
        int recordNum=studentInfoService.updateStuInfo(studentInfo);
        PrintWriter out=response.getWriter();
        if(recordNum==1){
            out.write("<script>alert('修改成功！');"+
                    "window.location.href='getAllStudentServlet'</script>");
        }else {
            out.write("<script>alert('Sorry,修改失败');"+
                    "window.location.href='getAllStudentServlet'</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int stuId=Integer.valueOf(request.getParameter("stuId"));

       studentInfo=studentInfoService.getStuInfoById(stuId);
       System.out.println(studentInfo); StuClassService stu = new StuClassServiceImpl();
       DormService ds = new DormServiceImpl();
       List<StuClass> stuClasses = stu.getAllClass();
       List<Dorm> dorms = ds.getAllDorm();
       request.setAttribute("stuClasses",stuClasses);
       request.setAttribute("dorms",dorms);

       request.setAttribute("studentInfo",studentInfo);
       request.getRequestDispatcher("jsp/admins/updateStudentInfo.jsp").forward(request,response);
    }
}
