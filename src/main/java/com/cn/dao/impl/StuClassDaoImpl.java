package com.cn.dao.impl;

import com.cn.dao.StuClassDao;
import com.cn.domain.Dorm;
import com.cn.domain.StuClass;
import com.cn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuClassDaoImpl implements StuClassDao {
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs;
    @Override
    public int addStuClass(StuClass stuClass) throws SQLException {
        String sql="insert into stuclass (class_Id,stu_Count,max_Num,tea_Id) values(?,?,?,?)";
        conn= JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);

        pstmt.setObject(1,stuClass.getClass_Id());
        pstmt.setObject(2,stuClass.getStu_Count());
        pstmt.setObject(3,stuClass.getMax_Num());
        pstmt.setObject(4,stuClass.getTea_Id());
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public int deleteClass(String class_Id) throws SQLException {
        String sql="delete from stuclass where class_Id = ?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1, class_Id);
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public int updateClass(StuClass stuClass) throws SQLException {
        String sql="update stuclass set stu_Count=?,max_Num=?,tea_Id=? where class_Id=?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1,stuClass.getStu_Count());
        pstmt.setObject(2,stuClass.getMax_Num());
        pstmt.setObject(3,stuClass.getTea_Id());
        pstmt.setObject(4,stuClass.getClass_Id());
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public List<StuClass> getAllClass() throws SQLException {
        String sql="select * from stuclass";
        conn= JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        List<StuClass> stuClasses=new ArrayList<StuClass>();
        while (rs.next()){
            String class_Id=rs.getString("class_Id");
            int stu_Count=rs.getInt("stu_Count");
            int max_Num=rs.getInt("max_Num");
            int tea_Id=rs.getInt("tea_Id");

            StuClass stuClass=new StuClass(class_Id,stu_Count,max_Num,tea_Id);
            stuClasses.add(stuClass);
        }
        conn.close();
        pstmt.close();
        rs.close();

        return stuClasses;
    }

    @Override
    public StuClass getClassById(String class_Id) throws SQLException {
        String sql="select * from stuclass where class_Id=?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1, class_Id);
        rs=pstmt.executeQuery();
        StuClass stuClass=null;
        while(rs.next()) {
            int stu_Count=rs.getInt("stu_Count");
            int max_Num=rs.getInt("max_Num");
            int tea_Id=rs.getInt("tea_Id");

            stuClass = new StuClass(class_Id,stu_Count,max_Num,tea_Id);

        }
        conn.close();
        pstmt.close();
        rs.close();
        return stuClass;
    }
}
