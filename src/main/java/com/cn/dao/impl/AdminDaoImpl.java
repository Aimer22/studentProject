package com.cn.dao.impl;

import com.cn.dao.AdminDao;
import com.cn.domain.Admin;
import com.cn.domain.Student;
import com.cn.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet rs;
    @Override
    public int addAdmin(Admin admin) throws SQLException {
        String sql = "insert into admin(adminUsername,adminPassword,flag,ifUse,registTimes,loginTimes) values (?,?,?,?,?,?)";
        conn= JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);

        pst.setObject(1,admin.getAdminUsername());
        pst.setObject(2,admin.getAdminPassword());
        pst.setObject(3,admin.getFlag());
        pst.setObject(4,admin.getIfUse());
        pst.setObject(5,admin.getRegistTimes());
        pst.setObject(6,admin.getLoginTimes());

        int recordNum=pst.executeUpdate();
        conn.close();
        pst.close();
        return recordNum;
    }

    @Override
    public int deleteAdmin(int adminId) throws SQLException {
        String sql="delete from admin where adminId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,adminId);

        int recordNum=pst.executeUpdate();
        conn.close();
        pst.close();
        return recordNum;
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        String sql="update admin set adminUserName=?,adminPassword=?,flag=?,ifUse=?,registTimes=?,loginTimes=? where adminId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,admin.getAdminUsername());
        pst.setObject(2,admin.getAdminPassword());
        pst.setObject(3,admin.getFlag());
        pst.setObject(4,admin.getIfUse());
        pst.setObject(5,admin.getRegistTimes());
        pst.setObject(6,admin.getLoginTimes());
        pst.setObject(7,admin.getAdminId());
        int status=pst.executeUpdate();
        conn.close();
        pst.close();

        return status;
    }

    @Override
    public List<Admin> getAllAdmin() throws SQLException {
        String sql="select * from admin";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        List<Admin> admins=new ArrayList<Admin>();
        while (rs.next()){
            int adminId = rs.getInt("adminId");
            String adminUserName = rs.getString("adminUserName");
            String adminPassword = rs.getString("adminPassword");
            int flag = rs.getInt("flag");
            Boolean ifUse = rs.getBoolean("ifUse");
            Timestamp registTimes = rs.getTimestamp("registTimes");
            Timestamp loginTimes = rs.getTimestamp("loginTimes");

            Admin admin=new Admin(adminId,adminUserName,adminPassword,flag,ifUse,registTimes,loginTimes);
            admins.add(admin);
        }
        conn.close();
        pst.close();
        rs.close();
        return admins;
    }

    @Override
    public Admin getAdminById(int adminId) throws SQLException {
        String sql="select * from admin where adminId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1, adminId);
        rs=pst.executeQuery();
        Admin admin=null;
        while(rs.next()) {
            String adminUserName = rs.getString("adminUserName");
            String adminPassword = rs.getString("adminPassword");
            int flag = rs.getInt("flag");
            Boolean ifUse = rs.getBoolean("ifUse");
            Timestamp registTimes = rs.getTimestamp("registTimes");
            Timestamp loginTimes = rs.getTimestamp("loginTimes");
            admin=new Admin(adminId,adminUserName, adminPassword, flag, ifUse,registTimes,loginTimes);

        }
        conn.close();
        pst.close();
        rs.close();
        return admin;
    }

    @Override
    public Admin getAdminByUserName(String adminUsername) throws SQLException {
        String sql="select * from admin where adminUsername=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1, adminUsername);
        rs=pst.executeQuery();
        Admin admin=null;
        while(rs.next()) {
            int adminId=rs.getInt("adminId");
            String adminPassword = rs.getString("adminPassword");
            int flag = rs.getInt("flag");
            Boolean ifUse = rs.getBoolean("ifUse");
            Timestamp registTimes = rs.getTimestamp("registTimes");
            Timestamp loginTimes = rs.getTimestamp("loginTimes");
            admin=new Admin(adminId,adminUsername, adminPassword, flag, ifUse,registTimes,loginTimes);

        }
        conn.close();
        pst.close();
        rs.close();
        return admin;
    }
}
