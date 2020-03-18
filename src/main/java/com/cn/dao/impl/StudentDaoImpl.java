package com.cn.dao.impl;



import com.cn.dao.StudentDao;
import com.cn.domain.Student;
import com.cn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs;


	public int add(Student student) throws SQLException {
		String sql="insert into student(stuNo,stuName,userName,password,registertimes,ifUse,if_finished_firstStep,if_finished_secondStep) values (?,?,?,?,?,?,?,?)";
		conn= JDBCUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1,student.getStuNo());
		pstmt.setObject(2,student.getStuName());
		pstmt.setObject(3,student.getUsername());
		pstmt.setObject(4,student.getPassword());
		pstmt.setObject(5,student.getRegisterTime());
		pstmt.setObject(6,student.isIfUse());
		pstmt.setObject(7,student.isIf_finished_firstStep());
		pstmt.setObject(8,student.isIf_finished_secondStep());
		int status=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}


	public int delete(int stuNo) throws SQLException {
		String sql="delete from student where stuNo = ?";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1, stuNo);
		int status=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public int update(Student student) throws SQLException {
		String sql="update student set stuName=?,userName=?,password=?,logintimes=?,ifUse=?,if_finished_firstStep=?,if_finished_secondStep=? where stuNo=?";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1,student.getStuName());
		pstmt.setObject(2,student.getUsername());
		pstmt.setObject(3,student.getPassword());
		pstmt.setObject(4,student.getLoginTime());
		pstmt.setObject(5,student.isIfUse());
		pstmt.setObject(6,student.isIf_finished_firstStep());
		pstmt.setObject(7,student.isIf_finished_secondStep());
		pstmt.setObject(8,student.getStuNo());
		int status=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public List<Student> getAll() throws SQLException {
		String sql="select * from student";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Student> students=new ArrayList<Student>();
		while(rs.next()) {
			Integer stuNo=rs.getInt("stuNo");
			String stuName=rs.getString("stuName");
			String userName=rs.getString("userName");
			String passWord=rs.getString("password");
			Timestamp registertimes=rs.getTimestamp("registertimes");
			Timestamp logintimes=rs.getTimestamp("logintimes");
			boolean ifuse=rs.getBoolean("ifUse");
			boolean if_finished_firstStep=rs.getBoolean("if_finished_firstStep");
			boolean if_finished_secondStep = rs.getBoolean("if_finished_secondStep");
			
			Student student=new Student(stuNo,stuName, userName, passWord, registertimes,logintimes,ifuse,if_finished_firstStep,if_finished_secondStep);
			students.add(student);		
		}
		pstmt.close();
		conn.close();
		rs.close();
		return students;
	}

	@Override
	public Student getStudentBystuNo(int stuId) throws SQLException {
		String sql="select * from student where stuNo=?";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1, stuId);
		rs=pstmt.executeQuery();
		Student student=null;
		while(rs.next()) {
			Integer stuNo=rs.getInt("stuNo");
			String stuName=rs.getString("stuName");
			String userName=rs.getString("userName");
			String passWord=rs.getString("password");
			Timestamp registertimes=rs.getTimestamp("registertimes");
			Timestamp logintimes=rs.getTimestamp("logintimes");
			boolean ifuse=rs.getBoolean("ifUse");
			boolean if_finished_firstStep=rs.getBoolean("if_finished_firstStep");
			boolean if_finished_secondStep = rs.getBoolean("if_finished_secondStep");

			student=new Student(stuNo,stuName, userName, passWord, registertimes,logintimes,ifuse,if_finished_firstStep,if_finished_secondStep);
					
		}
		conn.close();
		pstmt.close();
		rs.close();
		return student;
	}

	@Override
	public Student getStudentByName(String stuName) throws SQLException {
		String sql="select * from student where stuName=?";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1, stuName);
		rs=pstmt.executeQuery();
		Student student=null;
		while(rs.next()) {
			Integer stuNo=rs.getInt("stuNo");
			String stuname=rs.getString("stuName");
			String userName=rs.getString("userName");
			String passWord=rs.getString("password");
			Timestamp registertimes=rs.getTimestamp("registertimes");
			Timestamp logintimes=rs.getTimestamp("logintimes");
			boolean ifuse=rs.getBoolean("ifUse");
			boolean if_finished_firstStep=rs.getBoolean("if_finished_firstStep");
			boolean if_finished_secondStep = rs.getBoolean("if_finished_secondStep");

			student=new Student(stuNo,stuname, userName, passWord, registertimes,logintimes,ifuse,if_finished_firstStep,if_finished_secondStep);
					
		}
		conn.close();
		pstmt.close();
		rs.close();
		return student;
	}

	@Override
	public Student getStudentByUserName(String username) throws SQLException {
		String sql="select * from student where userName=?";
		conn=JDBCUtil.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setObject(1, username);
		rs=pstmt.executeQuery();
		Student student=null;
		while(rs.next()) {
			Integer stuNo=rs.getInt("stuNo");
			String stuname=rs.getString("stuName");
			String userName=rs.getString("userName");
			String passWord=rs.getString("password");
			Timestamp registertimes=rs.getTimestamp("registertimes");
			Timestamp logintimes=rs.getTimestamp("logintimes");
			boolean ifuse=rs.getBoolean("ifUse");
			boolean if_finished_firstStep=rs.getBoolean("if_finished_firstStep");
			boolean if_finished_secondStep = rs.getBoolean("if_finished_secondStep");

			student=new Student(stuNo,stuname, userName, passWord, registertimes,logintimes,ifuse,if_finished_firstStep,if_finished_secondStep);
					
		}
		conn.close();
		pstmt.close();
		rs.close();
		return student;
	}

}
