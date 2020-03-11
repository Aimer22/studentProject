package com.cn.dao.impl;



import com.cn.dao.StudentInfoDao;
import com.cn.domain.StudentInfo;
import com.cn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentInfoDaoImpl implements StudentInfoDao {
	
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs;

	@Override
	public int addStudentInfo(StudentInfo studentInfo) throws SQLException {
		String sql="insert into studentinfo (stuId,stuName,sex,age,birthPlace,stuNational,campus,major,stuClass,dormitory,phone,ifPay,userName) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		conn= JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, studentInfo.getStuId());
		pst.setObject(2, studentInfo.getStuName());
		pst.setObject(3, studentInfo.getSex());
		pst.setObject(4, studentInfo.getAge());
		pst.setObject(5, studentInfo.getBirthPlace());
		pst.setObject(6, studentInfo.getNational());
		pst.setObject(7, studentInfo.getCampus());
		pst.setObject(8, studentInfo.getMajor());
		pst.setObject(9, studentInfo.getStuClass());
		pst.setObject(10, studentInfo.getDormitory());
		pst.setObject(11, studentInfo.getPhone());
		pst.setBoolean(12, studentInfo.isIfPay());
		pst.setObject(13,studentInfo.getUserName());
		int status=pst.executeUpdate();
		conn.close();
		pst.close();
		
		return status;
	}

	@Override
	public int deleteStudentInfo(String stuId) throws SQLException {
		String sql="delete from studentinfo where stuId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, stuId);
		int status=pst.executeUpdate();
		conn.close();
		pst.close();
		return status;
	}

	@Override
	public int update(StudentInfo studentInfo) throws SQLException {
		String sql="update studentinfo set userName=?,stuName=?,sex=?,age=?,birthPlace=?,stuNational=?,campus=?,major=?,stuClass=?,dormitory=?,phone=?,ifPay=? where stuId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);

		pst.setObject(1,studentInfo.getUserName());
		pst.setObject(2, studentInfo.getStuName());
		pst.setObject(3, studentInfo.getSex());
		pst.setObject(4, studentInfo.getAge());
		pst.setObject(5, studentInfo.getBirthPlace());
		pst.setObject(6, studentInfo.getNational());
		pst.setObject(7, studentInfo.getCampus());
		pst.setObject(8, studentInfo.getMajor());
		pst.setObject(9, studentInfo.getStuClass());
		pst.setObject(10, studentInfo.getDormitory());
		pst.setObject(11, studentInfo.getPhone());
		pst.setBoolean(12, studentInfo.isIfPay());
		pst.setObject(13, studentInfo.getStuId());
		int status=pst.executeUpdate();
		conn.close();
		pst.close();
		return status;
	}

	@Override
	public List<StudentInfo> getAllStudentInfo() throws SQLException {
		String sql="select * from studentinfo";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		List<StudentInfo> studentinfo=new ArrayList<StudentInfo>();
		while(rs.next()){
			int stuInfoNo=rs.getInt("stuInfoNo");
			String stuId=rs.getString("stuId");
			String stuName=rs.getString("stuName");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dormitory");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");
			String userName=rs.getString("userName");
			
			StudentInfo studentInfo=new StudentInfo();
			studentInfo.setStuInfoNo(stuInfoNo);
			studentInfo.setStuId(stuId);
			studentInfo.setStuName(stuName);
			studentInfo.setSex(sex);
			studentInfo.setAge(age);
			studentInfo.setBirthPlace(birthPlace);
			studentInfo.setNational(national);
			studentInfo.setCampus(campus);
			studentInfo.setMajor(major);
			studentInfo.setStuClass(stuClass);
			studentInfo.setDormitory(dormitory);
			studentInfo.setPhone(phone);
			studentInfo.setIfPay(ifPay);
			studentInfo.setUserName(userName);
			
			studentinfo.add(studentInfo);
		}
		conn.close();
		pst.close();
		rs.close();
		return studentinfo;
	}

	@Override
	public StudentInfo getStuInfoByStuId(String stuId) throws SQLException {
		String sql="select * from studentinfo where stuId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, stuId);
		rs=pst.executeQuery();
		StudentInfo studentInfo=null;
		while(rs.next()) {
			int stuInfoNo=rs.getInt("stuInfoNo");
			String stuName=rs.getString("stuName");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dormitory");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");

			String userName=rs.getString("userName");

			studentInfo=new StudentInfo(stuInfoNo,userName, stuId, stuName, sex, age, birthPlace, national, campus, major, stuClass, dormitory, phone, ifPay);
			
		}
		conn.close();
		pst.close();
		rs.close();
		return studentInfo;
	}

	@Override
	public StudentInfo getStuInfoByStuName(String stuName) throws SQLException {
		String sql="select * from studentinfo where stuName=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, stuName);
		rs=pst.executeQuery();
		StudentInfo studentInfo=null;
		while(rs.next()) {
			int stuInfoNo=rs.getInt("stuInfoNo");
			String stuId=rs.getString("stuId");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dormitory");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");

			String userName=rs.getString("userName");
			studentInfo=new StudentInfo(stuInfoNo, userName,stuId, stuName, sex, age, birthPlace, national, campus, major, stuClass, dormitory, phone, ifPay);
			
		}
		conn.close();
		pst.close();
		rs.close();
		return studentInfo;
	}

}
