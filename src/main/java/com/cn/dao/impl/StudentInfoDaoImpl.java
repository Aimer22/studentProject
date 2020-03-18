package com.cn.dao.impl;



import com.cn.dao.StudentInfoDao;
import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;
import com.cn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentInfoDaoImpl implements StudentInfoDao {
	
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs;

	@Override
	public int addStudentInfo(StudentInfo studentInfo) throws SQLException {
		String sql="insert into studentinfo (sex,age,birthPlace,stuNational,campus,major,stuClass,dorm,phone,ifPay,stuNo) values(?,?,?,?,?,?,?,?,?,?,?)";
		conn= JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, studentInfo.getSex());
		pst.setObject(2, studentInfo.getAge());
		pst.setObject(3, studentInfo.getBirthPlace());
		pst.setObject(4, studentInfo.getNational());
		pst.setObject(5, studentInfo.getCampus());
		pst.setObject(6, studentInfo.getMajor());
		pst.setObject(7, studentInfo.getStuClass());
		pst.setObject(8, studentInfo.getDorm());
		pst.setObject(9, studentInfo.getPhone());
		pst.setObject(10, studentInfo.isIfPay());
		pst.setObject(11, studentInfo.getStuNo());
		int status=pst.executeUpdate();
		conn.close();
		pst.close();
		
		return status;
	}

	@Override
	public int deleteStudentInfo(int stuId) throws SQLException {
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
		String sql="update studentinfo set sex=?,age=?,birthPlace=?,stuNational=?,campus=?,major=?,stuClass=?,dorm=?,phone=?,ifPay=?,stuNo=? where stuId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);

		pst.setObject(1,studentInfo.getSex());
		pst.setObject(2, studentInfo.getAge());
		pst.setObject(3, studentInfo.getBirthPlace());
		pst.setObject(4, studentInfo.getNational());
		pst.setObject(5, studentInfo.getCampus());
		pst.setObject(6, studentInfo.getMajor());
		pst.setObject(7, studentInfo.getStuClass());
		pst.setObject(8, studentInfo.getDorm());
		pst.setObject(9, studentInfo.getPhone());
		pst.setObject(10, studentInfo.isIfPay());
		pst.setObject(11, studentInfo.getStuNo());
		pst.setObject(12, studentInfo.getStuId());
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
			int stuId=rs.getInt("stuId");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dorm");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");
			int stuNo=rs.getInt("stuNo");
			
			StudentInfo studentInfo=new StudentInfo(stuId,sex,age,birthPlace,national
			,campus,major,stuClass,dormitory,phone,ifPay,stuNo);
			studentinfo.add(studentInfo);
		}
		conn.close();
		pst.close();
		rs.close();
		return studentinfo;
	}

	@Override
	public List<ShowStuInfo> ShowAllStuInfo() throws SQLException {
		String sql="select * from studentinfo,student where studentinfo.stuNo = student.stuNo";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		List<ShowStuInfo> showStuInfos=new ArrayList<ShowStuInfo>();
		while (rs.next()){
			int stuId=rs.getInt("stuId");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dorm");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");
			String stuName=rs.getString("stuName");

			ShowStuInfo showStuInfo=new ShowStuInfo(stuId,sex,age,birthPlace,national,
					campus,major,stuClass,dormitory,phone,ifPay,stuName);
			showStuInfos.add(showStuInfo);
		}
		conn.close();
		pst.close();
		rs.close();
		return showStuInfos;
	}

	@Override
	public StudentInfo getStuInfoByStuId(int stuId) throws SQLException {
		String sql="select * from studentinfo where stuId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, stuId);
		rs=pst.executeQuery();
		StudentInfo studentInfo=null;
		while(rs.next()) {
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dorm");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");
			int stuNo=rs.getInt("stuNo");

			studentInfo=new StudentInfo(stuId,sex,age,birthPlace,national
					,campus,major,stuClass,dormitory,phone,ifPay,stuNo);
			
		}
		conn.close();
		pst.close();
		rs.close();
		return studentInfo;
	}

	@Override
	public StudentInfo getStuInfoByStuNo(int stuNo) throws SQLException {
		String sql="select * from studentinfo where stuNo=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, stuNo);
		rs=pst.executeQuery();
		StudentInfo studentInfo=null;
		while(rs.next()) {
			int stuId=rs.getInt("stuId");
			String sex=rs.getString("sex");
			int age=rs.getInt("age");
			String birthPlace=rs.getString("birthPlace");
			String national=rs.getString("stuNational");
			String campus=rs.getString("campus");
			String major=rs.getString("major");
			String stuClass=rs.getString("stuClass");
			String dormitory=rs.getString("dorm");
			String phone=rs.getString("phone");
			boolean ifPay=rs.getBoolean("ifPay");

			studentInfo=new StudentInfo(stuId,sex,age,birthPlace,national
					,campus,major,stuClass,dormitory,phone,ifPay,stuNo);
			
		}
		conn.close();
		pst.close();
		rs.close();
		return studentInfo;
	}



}
