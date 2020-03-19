package test;

import com.cn.domain.Tuition;
import com.cn.service.TuitionService;
import com.cn.service.impl.TuitionServiceImpl;
import com.cn.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class TuitionTest {
    private TuitionService tuitionService=new TuitionServiceImpl();
    private Tuition tuition=new Tuition();
    private List<Tuition> tuitionList=new ArrayList<Tuition>();
    public void testAdd(){

    }
    public void deleteTuition(){
    }

    public void testGetAllTuition(){
        tuitionList=tuitionService.getAllTuition();
        for (Tuition tuition:tuitionList){
            System.out.println(tuition);
        }
    }

    public void testGetTuitionBystuId(){
    }
    public void testGetTuitionByPayer(){
    }
    public void testUpdate(){

    }

    public static void main(String[] args) {
        TuitionTest tuitionTest=new TuitionTest();
//        tuitionTest.testAdd();
//        tuitionTest.deleteTuition();
        tuitionTest.testGetAllTuition();
//        tuitionTest.testGetTuitionBystuId();
//        tuitionTest.testGetTuitionByPayer();
//        tuitionTest.testUpdate();
    }




}
