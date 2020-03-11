package test;

import com.cn.domain.Teacher;
import com.cn.service.TeacherService;
import com.cn.service.impl.TeacherServiveImpl;
import com.cn.util.DateUtil;

import java.util.List;

public class testTeacherServive {
	TeacherService teacherService=new TeacherServiveImpl();
	
	public void testAddTeacher() {
		Teacher teacher=new Teacher();
		teacher.setTeaName("曹老师");
		teacher.setTuserName("caolaoshi");
		teacher.setTpassWord("123456");
		teacher.setRegistrationTimes(DateUtil.now());
		teacher.settClass("6107");
		teacher.setFlag(1);
		int recordnum=teacherService.addTeacher(teacher);
		System.out.println(recordnum);
	}
	public void testUpdateTeacher() {
		Teacher teacher=teacherService.getTeacherById(2);
		System.out.println(teacher);
		teacher.setTeaName("张老师");
		
		int recordnum=teacherService.updateTeacher(teacher);
		System.out.println(recordnum);
	}
	public void testGetAllTeacher(){
		List<Teacher> teachers=teacherService.getAllTeacher();
		System.out.println(teachers);
	}
	public void testGetTeacherByName() {
		Teacher teacher=teacherService.getTeacherByName("张老师");
		System.out.println(teacher);
		
	}
	
	public void testGetTeacherByuserName() {
		Teacher teacher=teacherService.getTeacherByUserName("wls123");
		System.out.println(teacher);
		
	}
	public static void main(String[] args) {		
			testTeacherServive tts=new testTeacherServive();
//			tts.testAddTeacher();
//			tts.testUpdateTeacher();
//			tts.testGetTeacherByName();
//			tts.testGetTeacherByuserName();
		tts.testGetAllTeacher();
			
		}
	}
	

