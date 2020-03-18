package com.cn.servlet;

import com.cn.domain.Student;
import com.cn.domain.Teacher;
import com.cn.service.StudentService;
import com.cn.service.TeacherService;
import com.cn.service.impl.StudentServiceImpl;
import com.cn.service.impl.TeacherServiveImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registrationServlert
 */
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int flag=Integer.parseInt(request.getParameter("flag")); 
		System.out.println(flag);
		//检测身份
		if (flag==2) {
			
			String stuName=request.getParameter("thename");
			String userName=request.getParameter("username");
			String passWord=request.getParameter("password");
			Timestamp regTime=new Timestamp(new Date().getTime());
			
			/**
			 * 将数据封装成对象
			 */
			Student student=new Student();
			student.setStuName(stuName);
			student.setUsername(userName);
			student.setPassword(passWord);
			student.setIfUse(false);
			student.setIf_finished_firstStep(false);
			student.setIf_finished_secondStep(false);
			student.setRegisterTime(regTime);
			
			/**
			 * 将数据存入数据库
			 */
			StudentService studentService=new StudentServiceImpl();
			int recordNumber=studentService.add(student);
			
			/*
			 * 检测数据是否成功存入数据库
			 */
			PrintWriter out=response.getWriter();
			if(recordNumber==1) {
				out.write("<script>alert('注册成功！');"+"window.location.href='jsp/login.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉，添加失败。');"+"window.location.href='jsp/register.jsp'</script>");
			}
			out.close();
			
		}
		if(flag==1) {
			String teaName=request.getParameter("thename");
			String tuserName=request.getParameter("username");
			String passWord=request.getParameter("password");
			Timestamp regTime=new Timestamp(new Date().getTime());
			
			//将数据封装成对象
			
			Teacher teacher=new Teacher();
			teacher.setFlag(flag);
			teacher.setRegistrationTimes(regTime);
			teacher.setTeaName(teaName);
			teacher.setTpassWord(passWord);
			teacher.setTuserName(tuserName);
			
			TeacherService teacherService=new TeacherServiveImpl();
			int recordNumber=teacherService.addTeacher(teacher);
			PrintWriter out=response.getWriter();
			if(recordNumber==1) {
				out.write("<script>alert('注册成功！');"+"window.location.href='jsp/login.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉，添加失败。');"+"window.location.href='jsp/register.jsp'</script>");
			}
			out.close();
			
			
		}
		
		
	}

}
