package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.domain.Tuition;
import com.cn.service.StudentInfoService;
import com.cn.service.TuitionService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.TuitionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class firstStepServlet extends HttpServlet {
    private static Logger logger=Logger.getLogger(firstStepServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        /**
         * 获取页面请求信息
         */
        String stuId=request.getParameter("stuId");
        String sex=request.getParameter("sex");
        int age=Integer.parseInt(request.getParameter("age"));
        String birthPlace=request.getParameter("birthPlace");
        String stuNational=request.getParameter("stuNational");
        String campus=request.getParameter("campus");
        String major=request.getParameter("major");
        String stuClass=request.getParameter("stuClass");
        String dorm=request.getParameter("dorm");
        String phone=request.getParameter("phone");

        /**
         * 从student  Session中获取值
         */
        Student student=(Student) request.getSession().getAttribute("student");
        HttpSession session=request.getSession();


        /**
         * 将数据封装成对象
         */
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setStuId(stuId);
        studentInfo.setAge(age);
        studentInfo.setBirthPlace(birthPlace);
        studentInfo.setNational(stuNational);
        studentInfo.setCampus(campus);
        studentInfo.setMajor(major);
        studentInfo.setStuClass(stuClass);
        studentInfo.setDormitory(dorm);
        studentInfo.setPhone(phone);
        studentInfo.setSex(sex);
        studentInfo.setIfPay(false);
        studentInfo.setUserName(student.getUsername());
        studentInfo.setStuName(student.getStuName());

        Tuition tuition=new Tuition();
        tuition.setInsurance(200);
        tuition.setAccommodation(1000);
        tuition.setFees(5000);
        tuition.setPayer(student.getStuName());
        tuition.setSpendOnBook(400);
        tuition.setStuId(request.getParameter("stuId"));
        tuition.setStateOfPay(false);

        /**
         * 将数据存入数据库
         */
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        TuitionService tuitionService=new TuitionServiceImpl();
        try {
            int recordNum=studentInfoService.addStudentInfo(studentInfo);
            int recordNUm2=tuitionService.addTuition(tuition);
            System.out.println(recordNUm2);
            StudentInfo stuInfo=studentInfoService.getStuInfoById(stuId);
            Tuition tuition1=tuitionService.getTuitionBystuId(stuId);

            /**
             * 将数据存入Session
             */
            session.setAttribute("studentInfo",stuInfo);
            session.setAttribute("tuition",tuition1);

            /**
             * 检测数据是否存入数据库
             */
            PrintWriter out=response.getWriter();
            if(recordNum==1&&recordNUm2==1) {
                out.write("<script>alert('完善信息成功！');"+"window.location.href='jsp/users/students/secondStep.jsp'</script>");
            }else {
                out.write("<script>alert('很抱歉，修改失败。');"+"window.location.href='jsp/users/students/firstStep.jsp'</script>");
            }
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
