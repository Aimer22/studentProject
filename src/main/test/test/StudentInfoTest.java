package test;




import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class StudentInfoTest {
    StudentInfoService studentInfoService=new StudentInfoServiceImpl();

    @Test
    public void testStuInfoAdd() throws SQLException {
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setSex("男");
        studentInfo.setAge(18);
        studentInfo.setBirthPlace("江西");
        studentInfo.setNational("汉族");
        studentInfo.setMajor("计算机");
        studentInfo.setCampus("南昌校区");
        studentInfo.setPhone("18379910986");
        studentInfo.setDorm("4125");
        studentInfo.setStuClass("1682062");
        studentInfo.setIfPay(false);
        studentInfo.setStuNo(8);
        int recordNum=studentInfoService.addStudentInfo(studentInfo);
        System.out.println(recordNum);
    }
    @Test
    public void testDeleteStuInfo(){
        studentInfoService.deleteStuInfo(26);
    }
    @Test
    public void testGetAllStuInfo(){
        List<StudentInfo> studentInfos=studentInfoService.getAllStuInfo();
        for (StudentInfo studentInfo:studentInfos){
            System.out.println(studentInfo);
        }
    }
    @Test
    public void testGetStuInfoById(){
        StudentInfo studentInfo=studentInfoService.getStuInfoById(25);
        System.out.println(studentInfo);
    }
    @Test
    public void  testGetStuInfoBystuNo(){
        StudentInfo studentInfo=studentInfoService.getStuInfoByNo(8);
        System.out.println(studentInfo);
    }
    @Test
    public void testUpdateStuInfo(){
        StudentInfo studentInfo=studentInfoService.getStuInfoByNo(8);
        System.out.println(studentInfo);
//        studentInfo.setDorm("4125");
        studentInfo.setSex("男");
        studentInfo.setAge(18);
        studentInfo.setNational("彝族");
        studentInfo.setPhone("18379910986");
        studentInfo.setBirthPlace("江西");
        studentInfo.setMajor("计算机");
        studentInfo.setCampus("南昌校区");
        studentInfo.setStuClass("1682062");
        int record=studentInfoService.updateStuInfo(studentInfo);
        System.out.println(record);
    }
    @Test
    public void testShowAllStuInfo(){
        List<ShowStuInfo> studentInfos=studentInfoService.showAllStuInfo();
        for (ShowStuInfo showStuInfo:studentInfos){
            System.out.println(showStuInfo);
        }
    }





}
