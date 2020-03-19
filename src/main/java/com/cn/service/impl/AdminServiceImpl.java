package com.cn.service.impl;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.domain.Admin;
import com.cn.domain.StudentInfo;
import com.cn.service.AdminService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();
    private static Logger logger=Logger.getLogger(AdminServiceImpl.class);
    private static int recordNum;
    @Override
    public int addAdmin(Admin admin) {
        if(admin!=null){
            try {
                recordNum=adminDao.addAdmin(admin);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return recordNum;
    }

    @Override
    public int deleteAdmin(int adminId) {
        if (adminId!=0){
            try {
                recordNum=adminDao.deleteAdmin(adminId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return recordNum;
    }

    @Override
    public int updateAdmin(Admin admin) {
        if(admin !=null){
            try {
                recordNum=adminDao.updateAdmin(admin);
            } catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }
        return recordNum;
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins=null;
        try {
            admins=adminDao.getAllAdmin();
        }catch(Exception e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Admin getAdminById(int adminId) {
        Admin admin=new Admin();
        if (adminId!=0){
            try {
                admin=adminDao.getAdminById(adminId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }

    @Override
    public Admin getAdminByUsername(String userName) {
        Admin admin=new Admin();
        if (userName!=null){
            try {
                admin=adminDao.getAdminByUserName(userName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }
}
