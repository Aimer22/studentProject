package com.cn.service.impl;


import com.cn.dao.TeacherDao;
import com.cn.dao.impl.TeacherDaoImpl;
import com.cn.domain.Teacher;
import com.cn.service.TeacherService;
import org.apache.log4j.Logger;

import java.util.List;


public class TeacherServiveImpl implements TeacherService {
	private TeacherDao teacherdao=new TeacherDaoImpl();
	private static Logger logger=Logger.getLogger(StudentServiceImpl.class);
	@Override
	public int addTeacher(Teacher teacher) {
		int recordnum=0;
		if(teacher!=null) {
			try {
				recordnum=teacherdao.addTeacher(teacher);
			} catch (Exception e) {
				logger.error(e.toString());
			}
			}
		return recordnum;
		}
	

	@Override
	public int deleteTeacher(Integer teaNo) {
		int recordnumber=0;
		if(teaNo!=null && teaNo!=0)
		try {
			recordnumber=teacherdao.deleteTeacher(teaNo);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return recordnumber;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		int recordnumber=0;
		if(teacher!=null)
		try {
			recordnumber=teacherdao.updateTeacher(teacher);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return recordnumber;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> list=null;
		try {
			list = teacherdao.getAllTeacher();
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher getTeacherById(Integer teaNo) {
		Teacher teacher=null;
		if(teaNo!=null&&teaNo!=0) {
		try {
			teacher=teacherdao.getTeacherById(teaNo);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		}else {
			logger.info("TeacherServiveImpl中teaNo为null或0");
		}
		return teacher;
	}

	@Override
	public Teacher getTeacherByName(String teaName) {
		Teacher teacher=null;
		System.out.println(teaName);
		if(teaName!=null&&!"".equals(teaName)) {			
			try {
				teacher=teacherdao.getTeacherByName(teaName);
			} catch (Exception e) {
				logger.error(e.toString());
				e.printStackTrace();
			}			
			
		}else {
			logger.info("找不到与getTeacherByName中teaName相匹配的姓名");
			
		}
		
		return teacher;
	}


	@Override
	public Teacher getTeacherByUserName(String userName) {
		Teacher teacher=null;
		System.out.println(userName);
		if(userName!=null&&!"".equals(userName)) {			
			try {
				teacher=teacherdao.getTeacherByUserName(userName);
			} catch (Exception e) {
				logger.error(e.toString());
				e.printStackTrace();
			}			
			
		}else {
			logger.info("找不到与getTeacherByUserName中userName相匹配的用户名");
			
		}
		
		return teacher;
	}

}
