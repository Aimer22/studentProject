package com.cn.servlet;






import com.cn.domain.Student;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class addStudentServlet
 */
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentServlet() {
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
		String stuName=request.getParameter("stuName");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		Integer age=Integer.valueOf(request.getParameter("age"));
		String birthplace=request.getParameter("birthplace");
		String major=request.getParameter("major");
		System.out.println(stuName);
		//获取当前时间
//		Timestamp registertime=new DateUtil().now();
		Timestamp registertime=new Timestamp(new Date().getTime());
		System.out.println(registertime);
		/**
		 * 将数据封装成对象
		 */
		Student student=new Student();
		student.setRegisterTime(registertime);
		student.setPassword(password);
		student.setStuName(stuName);
		student.setUsername(userName);
		/**
		 * 
		 * 将数据存入数据库并返回值
		 */
		StudentService studentService=new StudentServiceImpl();
		int recordNumber=studentService.add(student);
		
		/*
		 * 检测数据是否成功存入数据库
		 */
		PrintWriter out=response.getWriter();
		if(recordNumber==1) {
			out.write("<script>alert('添加成功！');"+"window.location.href='pages/admin/right/success.jsp'</script>");
		}else {
			out.write("<script>alert('很抱歉，添加失败。');"+"window.location.href='pages/admin/right/addStudent.jsp'</script>");
		}
		out.close();
		
		
	}

}
