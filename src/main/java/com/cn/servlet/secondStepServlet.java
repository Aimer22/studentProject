package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.domain.Tuition;
import com.cn.service.StudentInfoService;
import com.cn.service.StudentService;
import com.cn.service.TuitionService;
import com.cn.service.impl.StudentInfoServiceImpl;
import com.cn.service.impl.StudentServiceImpl;
import com.cn.service.impl.TuitionServiceImpl;
import com.cn.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/secondStepServlet")
public class secondStepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线程
        Student student = (Student) request.getSession().getAttribute("student");
        StudentInfoService studentInfoService = new StudentInfoServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        TuitionService tuitionService = new TuitionServiceImpl();
        Tuition tuition = tuitionService.getTuitionBystuNo(student.getStuNo());
        System.out.println("拿到了订单"+tuition);
        StudentInfo studentInfo = studentInfoService.getStuInfoByNo(student.getStuNo());
        //更新付款状态
        student.setIf_finished_secondStep(true);
        tuition.setStateOfPay(true);
        tuition.setTimeOfPay(DateUtil.now());
        studentInfo.setIfPay(true);
        int recordNum1 = tuitionService.updateTuition(tuition);
        int recordNum2 = studentInfoService.updateStuInfo(studentInfo);
        int recordNum3 = studentService.update(student);
        if(recordNum1==1&&recordNum2==1&&recordNum3==1){
            request.getRequestDispatcher("jsp/users/students/registSucceed.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("jsp/users/students/secondStep.jsp").forward(request,response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
