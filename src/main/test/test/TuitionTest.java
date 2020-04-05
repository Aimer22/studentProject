package test;

import com.cn.domain.Tuition;
import com.cn.service.TuitionService;
import com.cn.service.impl.TuitionServiceImpl;
import com.cn.util.DateUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TuitionTest {
    private TuitionService tuitionService=new TuitionServiceImpl();
    private List<Tuition> tuitionList=new ArrayList<Tuition>();
    @Test
    public void testAdd(){
        Tuition tuition = new Tuition();
        tuition.setStuNo(18);
        tuition.setFees(1000);
        tuition.setInsurance(100);
        tuition.setAccommodation(200);
        tuition.setSpendOnBook(500);
        int re=tuitionService.addTuition(tuition);
        System.out.println(re);
    }
    public void deleteTuition(){
    }
@Test
    public void testGetAllTuition(){
        tuitionList=tuitionService.getAllTuition();
        for (Tuition tuition:tuitionList){
            System.out.println(tuition);
        }
    }
@Test
    public void testGetTuitionBystuId(){
        Tuition tuition = tuitionService.getTuitionBystuNo(19);
        System.out.println(tuition);
        tuition.setStateOfPay(true);
        tuition.setTimeOfPay(DateUtil.now());
        int record = tuitionService.updateTuition(tuition);
        System.out.println(tuition);
        System.out.println(record);
    }
    public void testGetTuitionByPayer(){
    }
    @Test
    public void testUpdate(){
        TuitionService tuitionService = new TuitionServiceImpl();
        Tuition tui = tuitionService.getTuitionBystuNo(19);
        System.out.println(tui);
        tui.setTimeOfPay(DateUtil.now());
        tui.setStateOfPay(true);
        int recordNum = tuitionService.updateTuition(tui);
        System.out.println(recordNum);
    }


}
