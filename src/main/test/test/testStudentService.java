package test;


import java.util.List;

import com.cn.domain.Student;
import com.cn.service.StudentService;
import com.cn.service.impl.StudentServiceImpl;
import com.cn.util.DateUtil;

public class testStudentService {
	
	StudentService studentService=new StudentServiceImpl();
	
	
	public void testAdd() {
		Student stu=new Student();
		stu.setStuName("shuai");
		stu.setUsername("caoshuai");
		stu.setPassword("123456");
		stu.setRegisterTime(DateUtil.now());
		
		studentService.add(stu);
	}
	
	public void testDelete() {

		studentService.delete(10);
	}
	
	public void testUpdate() {
		Student student=studentService.getStudentByNo(9);
		System.out.println(student);
		student.setLoginTime(DateUtil.now());
		int recordNum=studentService.update(student);
		System.out.println(recordNum);
	}
	public void testGetAll() {
		List<Student> students=studentService.getAll();
		for(Student student:students) {
			System.out.println(student);
		}
	}
	
	public void testGetStudentById() {
		Student student=studentService.getStudentByNo(0);
		System.out.println(student);
	}
	
	public void testGetStudentByName() {
		Student student=studentService.getStudentByName("曹帅");
//		student.setSex("nan");
//		student.setIfUse(1);
//		int recordnum=studentService.update(student);
//		System.out.println(recordnum);
		System.out.println(student);
	}
	
	public void testGetStudentByUserName() {
		Student student=studentService.getStudentByUserName("cs351");
		
		System.out.println(student);
	}
		
	

	public static void main(String[] args) {
		testStudentService testStudentService=new testStudentService();
//		testStudentService.testAdd();
//		testStudentService.testGetAll();
//		testStudentService.testGetStudentByName();
		testStudentService.testUpdate();
//		testStudentService.testGetStudentByUserName();
//		testStudentService.testDelete();
	}

	
	
	

}
