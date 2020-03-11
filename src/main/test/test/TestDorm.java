package test;

import com.cn.domain.Dorm;
import com.cn.service.DormService;
import com.cn.service.impl.DormServiceImpl;

import java.util.List;

public class TestDorm {
    DormService dormService=new DormServiceImpl();
    Dorm dorm=new Dorm();


    public void testAddDorm(){
        dorm.setDorm_Num("4121");
        dorm.setDorm_Sex("男生宿舍");
        dorm.setAllStu(4);
        dorm.setLivedNum(1);

        dormService.addDorm(dorm);
    }

    public void  testDelete(){

    }

    public void testUpdate(){
        dorm=dormService.getDormByNum("4121");
        dorm.setDorm_Sex("男生宿舍");
        dormService.updateDorm(dorm);

    }

    public void getAll(){
        List<Dorm> dorms= dormService.getAllDorm();
        for(Dorm dorm:dorms){
            System.out.println(dorm);
        }


    }

    public void getDormById(){
        Dorm dorm=null;
        dorm=dormService.getDormByNum("4121");
        System.out.println(dorm);
    }
    public static void main(String[] args) {
        TestDorm testDorm=new TestDorm();
//        testDorm.testAddDorm();
        testDorm.getAll();
//        testDorm.getDormById();
//        testDorm.testUpdate();
    }

}
