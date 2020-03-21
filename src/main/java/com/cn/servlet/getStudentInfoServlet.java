package com.cn.servlet;





import com.cn.domain.Student;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class getStudentInfoServlet
 */
@WebServlet("/getStudentInfoServlet")
public class getStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public getStudentInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//从Session中获取登录对象，将其转发到页面中
		Student student=(Student) request.getSession().getAttribute("student");

		StudentInfoService studentInfoService = new StudentInfoServiceImpl();
		StudentInfo studentInfo = studentInfoService.getStuInfoByNo(student.getStuNo());
		request.setAttribute("student", student);
		request.setAttribute("studentInfo",studentInfo);
		System.out.println("拿到了studentInfo"+studentInfo);
		request.getRequestDispatcher("jsp/users/students/ownInfo.jsp").forward(request, response);
		
	}

	
	

}
