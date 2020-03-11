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
        tuition.setStuId("168206211");
        tuition.setPayer("cs");
        tuition.setAccommodation(400);
        tuition.setSpendOnBook(400);
        tuition.setInsurance(400);
        tuition.setFees(5000);
        tuition.setPayTime(DateUtil.now());
        tuition.setStateOfPay(false);

        int recordNum=tuitionService.addTuition(tuition);
        System.out.println(recordNum);
    }
    public void deleteTuition(){
        int state=tuitionService.deleteTuition("168206211");
        System.out.println(state);
    }

    public void testGetAllTuition(){
        tuitionList=tuitionService.getAllTuition();
        for (Tuition tuition:tuitionList){
            System.out.println(tuition);
        }
    }

    public void testGetTuitionBystuId(){
        tuition=tuitionService.getTuitionBystuId("168206211");
        System.out.println(tuition);
    }
    public void testGetTuitionByPayer(){
        tuition=tuitionService.getTuitionByPayer("曹帅");
        System.out.println(tuition);
    }
    public void testUpdate(){
        tuition=tuitionService.getTuitionByPayer("曹帅");
        tuition.setFees(3000);
        int state=tuitionService.updateTuition(tuition);
        System.out.println(state);

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
