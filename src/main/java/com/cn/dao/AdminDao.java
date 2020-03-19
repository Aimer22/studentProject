package com.cn.dao;

import com.cn.domain.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    int addAdmin(Admin admin) throws SQLException;

    int deleteAdmin(int adminId) throws SQLException;

    int updateAdmin(Admin admin) throws  SQLException;

    List<Admin> getAllAdmin() throws SQLException;

    Admin getAdminById(int adminId) throws SQLException;

    Admin getAdminByUserName(String adminUsername) throws SQLException;
}
