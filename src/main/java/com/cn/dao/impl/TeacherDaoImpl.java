package com.cn.dao.impl;



import com.cn.dao.TeacherDao;
import com.cn.domain.Teacher;
import com.cn.util.DateUtil;
import com.cn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class TeacherDaoImpl implements TeacherDao {
	
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs;

	@Override
	public int addTeacher(Teacher teacher) throws SQLException {
		String sql="insert into teacher(teaId,teaName,TuserName,TpassWord,Tclass,registrationTimes,flag)values(?,?,?,?,?,?,?)";
		conn= JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1,teacher.getTeaId());
		pst.setObject(2, teacher.getTeaName());
		pst.setObject(3, teacher.getTuserName());
		pst.setObject(4, teacher.getTpassWord());
		pst.setObject(5, teacher.gettClass());
		pst.setTimestamp(6, DateUtil.now());
		pst.setObject(7,teacher.getFlag());
		int state=pst.executeUpdate();
		conn.close();
		pst.close();
		return state;
		
	}

	@Override
	public int deleteTeacher(Integer teaNo) throws SQLException {
		String sql="delete from teacher where teaId = ?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, teaNo);
		int status=pst.executeUpdate();
		pst.close();
		conn.close();
		return status;
	}

	@Override
	public int updateTeacher(Teacher teacher) throws SQLException {
		String sql="update teacher set teaName=?,TuserName=?,TpassWord=?,Tclass=?,logintimes=?,ifUse=? where teaId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1,teacher.getTeaName());
		pst.setObject(2,teacher.getTuserName());
		pst.setObject(3,teacher.getTpassWord());
		pst.setObject(4,teacher.gettClass());
		pst.setTimestamp(5, DateUtil.now());
		pst.setBoolean(6, teacher.isIfUse());
		pst.setObject(7, teacher.getTeaId());
		int status=pst.executeUpdate();
		pst.close();
		conn.close();
		return status;
	}

	@Override
	public List<Teacher> getAllTeacher() throws SQLException {
		String sql="select * from teacher";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		List<Teacher> teachers=new ArrayList<Teacher>();
		while(rs.next()) {
			Integer teaId=rs.getInt("teaId");
			String teaName=rs.getString("teaName");
			String tuserName=rs.getString("TuserName");
			String tpassWord=rs.getString("TpassWord");
			String tclass=rs.getString("Tclass");
			Timestamp registrationTimes=rs.getTimestamp("registrationTimes");
			Timestamp loginTimes=rs.getTimestamp("loginTimes");
			boolean ifUse=rs.getBoolean("ifUse");
			
			Teacher teacher=new Teacher();
			teacher.setTeaId(teaId);
			teacher.setTeaName(teaName);
			teacher.setTuserName(tuserName);
			teacher.setTpassWord(tpassWord);
			teacher.settClass(tclass);
			teacher.setRegistrationTimes(registrationTimes);
			teacher.setLoginTimes(loginTimes);
			teacher.setIfUse(ifUse);
			
			teachers.add(teacher);
			
		}
		pst.close();
		conn.close();
		rs.close();
		return teachers;
	}

	@Override
	public Teacher getTeacherById(Integer teaNo) throws SQLException {
		String sql="select * from teacher where teaId=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, teaNo);
		rs=pst.executeQuery();
		Teacher teacher=null;
		while(rs.next()) {
			Integer teaId=rs.getInt("teaId");
			String teaName=rs.getString("teaName");
			String tuserName=rs.getString("TuserName");
			String tpassWord=rs.getString("TpassWord");
			String tclass=rs.getString("Tclass");
			Timestamp registrationTimes=rs.getTimestamp("registrationTimes");
			Timestamp loginTimes=rs.getTimestamp("loginTimes");
			boolean ifUse=rs.getBoolean("ifUse");
			Integer flag=rs.getInt("flag");
			teacher=new Teacher(teaId,teaName, tuserName, tpassWord, tclass, registrationTimes, loginTimes, ifUse, flag);
		}
		conn.close();
		pst.close();
		rs.close();
		return teacher;
	}

	@Override
	public Teacher getTeacherByName(String teaName) throws SQLException {
		String sql="select * from teacher where teaName=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, teaName);
		rs=pst.executeQuery();
		Teacher teacher=null;
		while(rs.next()) {
			Integer teaId=rs.getInt("teaId");
			String teaname=rs.getString("teaName");
			String tuserName=rs.getString("TuserName");
			String tpassWord=rs.getString("TpassWord");
			String tclass=rs.getString("Tclass");
			Timestamp registrationTimes=rs.getTimestamp("registrationTimes");
			Timestamp loginTimes=rs.getTimestamp("loginTimes");
			boolean ifUse=rs.getBoolean("ifUse");
			Integer flag=rs.getInt("flag");
			teacher=new Teacher(teaId,teaname,tuserName, tpassWord, tclass, registrationTimes, loginTimes, ifUse, flag);
		}
		conn.close();
		pst.close();
		rs.close();
		return teacher;
	}

	@Override
	public Teacher getTeacherByUserName(String userName) throws SQLException {
		String sql="select * from teacher where TuserName=?";
		conn=JDBCUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setObject(1, userName);
		rs=pst.executeQuery();
		Teacher teacher=null;
		while(rs.next()) {
			
			Integer teaId=rs.getInt("teaId");
			String teaname=rs.getString("teaName");
			String tuserName=rs.getString("TuserName");
			String tpassWord=rs.getString("TpassWord");
			String tclass=rs.getString("Tclass");
			Timestamp registrationTimes=rs.getTimestamp("registrationTimes");
			Timestamp loginTimes=rs.getTimestamp("loginTimes");
			boolean ifUse=rs.getBoolean("ifUse");
			Integer flag=rs.getInt("flag");
			teacher=new Teacher(teaId,teaname,tuserName, tpassWord, tclass, registrationTimes, loginTimes, ifUse, flag);
		}
		conn.close();
		pst.close();
		rs.close();
		return teacher;
	}

}
