package test;

import com.cn.domain.StuClass;
import com.cn.service.StuClassService;
import com.cn.service.impl.StuClassServiceImpl;
import org.junit.Test;

import java.util.List;

public class StuClassTest {
    private StuClassService stu = new StuClassServiceImpl();
    @Test
    public void testAddClass(){
        StuClass stuClass=new StuClass();
        stuClass.setClass_Id("1685132");
        stuClass.setMax_Num(40);
        stuClass.setStu_Count(0);
        stuClass.setTea_Id(1);
        stu.addStuClass(stuClass);
    }

    @Test
    public void testDeleteClass(){
        stu.deleteClass("1682061");
    }
    @Test
    public void testGetAllClass(){
        List<StuClass> stuClasses=stu.getAllClass();
        for(StuClass stuClass:stuClasses){
            System.out.println(stuClass);
        }
    }
    @Test
    public  void testGetClassById(){
        StuClass stuClass=stu.getClassById("1682062");
        System.out.println(stuClass);
    }
    @Test
    public void testUpdate(){
        StuClass stuClass=stu.getClassById("1682062");
        stuClass.setTea_Id(2);
        stu.updateClass(stuClass);
    }
}
