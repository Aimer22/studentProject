package com.cn.dao.impl;

import com.cn.dao.DormDao;
import com.cn.domain.Dorm;
import com.cn.domain.Student;
import com.cn.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DormDaoImpl implements DormDao {

    private Connection conn=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs;

    @Override
    public int AddDorm(Dorm dorm) throws SQLException {
        String sql="insert into Dorm(dorm_Num,dorm_Sex,allStu,livedNum) values (?,?,?,?)";
        conn= JDBCUtil.getConnection();

        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1,dorm.getDorm_Num());
        pstmt.setObject(2,dorm.getDorm_Sex());
        pstmt.setObject(3,dorm.getAllStu());
        pstmt.setObject(4,dorm.getLivedNum());
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public int deleteDorm(String dorm_Num) throws SQLException {
        String sql="delete from dorm where dorm_Num = ?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1, dorm_Num);
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public int updateDorm(Dorm dorm) throws SQLException {
        String sql="update dorm set dorm_Sex=?,allStu=?,livedNum=? where dorm_Num=?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1,dorm.getDorm_Sex());
        pstmt.setObject(2,dorm.getAllStu());
        pstmt.setObject(3,dorm.getDorm_Num());
        pstmt.setObject(4,dorm.getDorm_Num());
        int status=pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return status;
    }

    @Override
    public List<Dorm> getAllDorm() throws SQLException {
        System.out.println("进来了");
        String sql="select * from dorm";
        conn= JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        List<Dorm> dorms=new ArrayList<Dorm>();
        while (rs.next()){
            String Dorm_Num=rs.getString("dorm_Num");
            String Dorm_Sex=rs.getString("dorm_Sex");
            int AllStu=rs.getInt("allStu");
            int LivedNum=rs.getInt("livedNum");

            Dorm dorm=new Dorm(Dorm_Num,Dorm_Sex,AllStu,LivedNum);
            dorms.add(dorm);
        }
        conn.close();
        pstmt.close();
        rs.close();

        return dorms;
    }

    @Override
    public Dorm getDormByDormNum(String Dorm_Num) throws SQLException {
        String sql="select * from dorm where dorm_Num=?";
        conn=JDBCUtil.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setObject(1, Dorm_Num);
        rs=pstmt.executeQuery();
        Dorm dorm=null;
        while(rs.next()) {
            String Dorm_Sex=rs.getString("dorm_Sex");
            int AllStu=rs.getInt("allStu");
            int LivedNum=rs.getInt("livedNum");

           dorm= new Dorm(Dorm_Num,Dorm_Sex,AllStu,LivedNum);

        }
        conn.close();
        pstmt.close();
        rs.close();
        return dorm;
    }
}
