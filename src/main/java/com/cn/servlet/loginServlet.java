package com.cn.servlet;


import com.cn.domain.Admin;
import com.cn.domain.Student;
import com.cn.domain.Teacher;
import com.cn.service.AdminService;
import com.cn.service.StudentService;
import com.cn.service.TeacherService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.service.impl.StudentServiceImpl;
import com.cn.service.impl.TeacherServiveImpl;
import com.cn.util.DateUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class loginServlet
 */

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int flag=Integer.parseInt(request.getParameter("flag")); 
		
		StudentService studentService=new StudentServiceImpl();
		TeacherService teacherService=new TeacherServiveImpl();
		AdminService adminService=new AdminServiceImpl();
		Student student=studentService.getStudentByUserName(username);
		Teacher teacher=teacherService.getTeacherByUserName(username);
		Admin admin=adminService.getAdminByUsername(username);
				
		//创建session，存储登录的用户对象
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(30*60);
		
		PrintWriter out=response.getWriter();
		if (flag==1){
			{
				if(teacher!=null) {
					if(password.equals(teacher.getTpassWord())) {
						//更新登录信息
						teacher.setIfUse(true);
						teacher.setLoginTimes(DateUtil.now());
						teacherService.updateTeacher(teacher);

						//将登录对象加入会话
						session.setAttribute("teacher", teacher);

						//跳转界面
						out.write("<script>alert('登陆成功，欢迎您！"+teacher.getTeaName()+"');"
								+"window.location.href='jsp/users/teachers/teacherMain.jsp'</script>");
					}
				}else {
					out.write("<script>alert('密码有误，请重新输入。')"
							+"window.location.href='jsp/login.jsp'</script>");
				}
			}
		}
		if(flag==2) {
			if(student!=null) {
				if(password.equals(student.getPassword())) {
					
					//更新登录信息
					student.setIfUse(true);
					student.setLoginTime(DateUtil.now());
					studentService.update(student);
					
					//将登录对象加入会话
					session.setAttribute("student", student);
					
					//跳转界面
					out.write("<script>alert('登陆成功，欢迎您！"+student.getStuName()+"');"
							+"window.location.href='jsp/users/students/StudentMain.jsp'</script>");
					
				}else {
					out.write("<script>alert('密码有误，请重新输入。')"
				+"window.location.href='pages/users/home.jsp'</script>");
				}
			} else {
				out.write("<script>alert('该用户不存在！');" + "window.location.href='pages/users/home.jsp'</script>");
			}
			}
		if (flag==3){
			if(admin!=null){
				if (password.equals(admin.getAdminPassword())) {
					//更新登录信息
					admin.setIfUse(true);
					admin.setLoginTimes(DateUtil.now());
					adminService.updateAdmin(admin);

					//将登录对象加入会话
					session.setAttribute("admin", admin);

					//跳转界面
					out.write("<script>alert('登陆成功，欢迎您！"+admin.getAdminUsername()+"');"
							+"window.location.href='jsp/admins/adminMain.jsp'</script>");
				}else{
					out.write("<script>alert('密码有误，请重新输入。')"
							+"window.location.href='jsp/login.jsp'</script>");
				}
				}else {
				out.write("<script>alert('该用户不存在，请重新输入。')"
						+"window.location.href='jsp/login.jsp'</script>");
			}
			}
		}
}
