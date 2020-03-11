package com.cn.servlet;





import com.cn.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class getStudentInfoServlet
 */
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//从Session中获取登录对象，将其转发到页面中
		Student student=(Student) request.getSession().getAttribute("student");
		request.setAttribute("student", student);
		request.getRequestDispatcher("pages/users/students/studentOwnInfo.jsp").forward(request, response);
		
	}

	
	

}
