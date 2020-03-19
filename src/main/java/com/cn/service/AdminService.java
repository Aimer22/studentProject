package com.cn.service;

import com.cn.domain.Admin;

import java.util.List;

public interface AdminService {
    int addAdmin (Admin admin);

    int deleteAdmin (int adminId);

    int updateAdmin (Admin admin);

    List<Admin> getAllAdmin();

    Admin getAdminById(int adminId);

    Admin getAdminByUsername(String userName);
}
