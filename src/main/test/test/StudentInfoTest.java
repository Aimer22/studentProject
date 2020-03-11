package test;




import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import com.cn.service.impl.StudentInfoServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentInfoTest {
    StudentInfoService studentInfoService=new StudentInfoServiceImpl();

    public void testStuInfoAdd() throws SQLException {
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setAge(18);
        studentInfo.setUserName("cs351");
        studentInfo.setBirthPlace("江西");
        studentInfo.setCampus("计算机学院");
        studentInfo.setDormitory("4121");
        studentInfo.setIfPay(false);
        studentInfo.setMajor("计算机");
        studentInfo.setNational("江西上饶");
        studentInfo.setPhone("18379910986");
        studentInfo.setStuClass("1682062");
        studentInfo.setStuId("168206207");
        studentInfo.setStuName("曹帅");
        studentInfo.setSex("男");

        int recordNum=studentInfoService.addStudentInfo(studentInfo);
        System.out.println(recordNum);
    }
    public void testDeleteStuInfo(){
        int recordNum=studentInfoService.deleteStuInfo("168206207");
        System.out.println(recordNum);
    }
    public void testGetAllStuInfo(){
        List<StudentInfo> studentInfos=studentInfoService.getAllStuInfo();
        for (StudentInfo studentInfo:studentInfos){
            System.out.println(studentInfo);
        }
    }
    public void testGetStuInfoById(){
        StudentInfo studentInfo=studentInfoService.getStuInfoById("168206207");
        System.out.println(studentInfo);
    }
    public void  testGetStuInfoBystuName(){
        StudentInfo studentInfo=studentInfoService.getStuInfoByName("曹帅");
        System.out.println(studentInfo);
    }
    public void testUpdateStuInfo(){
        StudentInfo studentInfo=studentInfoService.getStuInfoByName("曹帅");
        studentInfo.setNational("彝族");
        int recordNum=studentInfoService.updateStuInfo(studentInfo);
        System.out.println(recordNum);
        System.out.println(studentInfo);
    }

    public static void main(String[] args) throws SQLException {
        StudentInfoTest studentInfoTest=new StudentInfoTest();
//        studentInfoTest.testStuInfoAdd();
//        studentInfoTest.testDeleteStuInfo();
//        studentInfoTest.testGetAllStuInfo();
//        studentInfoTest.testGetStuInfoById();
//        studentInfoTest.testGetStuInfoBystuName();
        studentInfoTest.testUpdateStuInfo();
    }



}
