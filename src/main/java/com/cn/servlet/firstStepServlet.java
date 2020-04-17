package com.cn.servlet;

import com.cn.domain.*;
import com.cn.service.*;
import com.cn.service.impl.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/firstStepServlet")
public class firstStepServlet extends HttpServlet {
    private static Logger logger=Logger.getLogger(firstStepServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("第一步已完成");

        /**
         * 获取页面请求信息
         */
        int age=Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sex");
        String birthPlace=request.getParameter("birthPlace");
        String stuNational=request.getParameter("national");
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
        studentInfo.setAge(age);
        studentInfo.setBirthPlace(birthPlace);
        studentInfo.setNational(stuNational);
        studentInfo.setCampus(campus);
        studentInfo.setMajor(major);
        studentInfo.setStuClass(stuClass);
        studentInfo.setPhone(phone);
        studentInfo.setSex(sex);
        studentInfo.setDorm(dorm);
        studentInfo.setIfPay(false);
        studentInfo.setStuNo(student.getStuNo());
        studentInfo.setStuName(student.getStuName());

        Tuition tuition=new Tuition();
        tuition.setInsurance(200);
        tuition.setAccommodation(1000);
        tuition.setFees(5000);
        tuition.setSpendOnBook(400);
        tuition.setStuNo(student.getStuNo());
        System.out.println(tuition);
        tuition.setStateOfPay(false);

        /**
         * 将数据存入数据库
         */
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        TuitionService tuitionService=new TuitionServiceImpl();

        try {
            int recordNum=studentInfoService.addStudentInfo(studentInfo);
            int recordNum2=tuitionService.addTuition(tuition);
            System.out.println(recordNum2);
            Tuition tuitions=tuitionService.getTuitionBystuNo(student.getStuNo());

            /**
             * 将数据存入Session
             */
            session.setAttribute("tuition",tuitions);
            session.setAttribute("studentInfo",studentInfo);

            /**
             * 检测数据是否存入数据库
             */
            PrintWriter out=response.getWriter();
            if(recordNum==1&&recordNum2==1) {
                //更新学生账户信息
                StudentService studentService = new StudentServiceImpl();
                student.setIf_finished_firstStep(true);
                studentService.update(student);
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

        StuClassService stu = new StuClassServiceImpl();
        DormService ds = new DormServiceImpl();
        List<StuClass> stuClasses = stu.getAllClass();
        List<Dorm> dorms = ds.getAllDorm();
        request.setAttribute("stuClasses",stuClasses);
        request.setAttribute("dorms",dorms);
        request.getRequestDispatcher("jsp/users/students/firstStep.jsp").forward(request,response);
    }
}
