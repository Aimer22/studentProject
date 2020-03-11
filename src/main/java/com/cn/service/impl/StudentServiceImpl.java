package com.cn.service.impl;

import com.cn.dao.StudentDao;
import com.cn.dao.impl.StudentDaoImpl;
import com.cn.domain.Student;
import com.cn.service.StudentService;
import org.apache.log4j.Logger;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	
	private StudentDao studentDao=new StudentDaoImpl();
	private static Logger logger=Logger.getLogger(StudentServiceImpl.class);
	@Override
	public int add(Student student) {
		int recordnumber=0;
		if(student!=null) {
		try {
			recordnumber=studentDao.add(student);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		}
		return recordnumber;
	}

	@Override
	public int delete(int stuNo) {
		int recordnumber=0;
		if(stuNo!=0)
		try {
			recordnumber=studentDao.delete(stuNo);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return recordnumber;
	}

	@Override
	public int update(Student student) {
		int recordnumber=0;
		if(student!=null)
		try {
			recordnumber=studentDao.update(student);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return recordnumber;
	}

	@Override
	public List<Student> getAll() {
		List<Student> list=null;
		try {
			list = studentDao.getAll();
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student getStudentByNo(int stuNo) {
		Student student=null;
		if(stuNo!=0) {
		try {
			student=studentDao.getStudentBystuNo(stuNo);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		}else {
			logger.info("StudentServiceImpl中StuId为null或0");
		}
		return student;
	}

	@Override
	public Student getStudentByName(String stuName) {
		Student student=null;
		if(stuName!=null&&!"".equals(stuName)) {			
			try {
				student=studentDao.getStudentByName(stuName);
			} catch (Exception e) {
				logger.error(e.toString());
				e.printStackTrace();
			}			
			
		}else {
			logger.info("找不到与getStudentByName中stuName相匹配的姓名");
			
		}
		
		return student;
	}

	@Override
	public Student getStudentByUserName(String username) {
		Student student=null;
		System.out.println( username);
		if(username!=null&&!"".equals(username)) {			
			try {
				student=studentDao.getStudentByUserName(username);
			} catch (Exception e) {
				logger.error(e.toString());
				e.printStackTrace();
			}			
			
		}else {
			logger.info("找不到与getStudentByUserName中username相匹配的用户名");
			
		}
		
		return student;
	}

}
