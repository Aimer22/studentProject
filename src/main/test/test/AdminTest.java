package test;

import com.cn.domain.Admin;
import com.cn.service.AdminService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.util.DateUtil;

import java.util.List;

public class AdminTest {
    AdminService adminService=new AdminServiceImpl();
    public void testAddAdmin(){
        Admin admin=new Admin();
        admin.setAdminUsername("admin");
        admin.setAdminPassword("123456");
        admin.setFlag(2);
        admin.setRegistTimes(DateUtil.now());
        adminService.addAdmin(admin);

    }
    public  void testDeleteAdmin(){
        int recordNum=adminService.deleteAdmin(2);
        System.out.println(recordNum);
    }
    public  void testUpdateAdmin(){

    }
    public  void testGetAll(){
        List<Admin> admins=adminService.getAllAdmin();
        System.out.println(admins);
    }
    public void testGetAdminById(){
        Admin admin=adminService.getAdminById(1);
        System.out.println(admin);
    }
    public void testGetByUsername(){
        Admin admin=adminService.getAdminByUsername("admin");
        System.out.println(admin);
    }
    public static void main(String[] args) {
        AdminTest adminTest=new AdminTest();
//        adminTest.testAddAdmin();
//        adminTest.testGetAll();
//        adminTest.testGetAdminById();
//        adminTest.testDeleteAdmin();
        adminTest.testGetByUsername();
    }
}
