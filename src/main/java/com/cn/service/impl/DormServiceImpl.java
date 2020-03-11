package com.cn.service.impl;

import com.cn.dao.DormDao;
import com.cn.dao.impl.DormDaoImpl;
import com.cn.domain.Dorm;
import com.cn.service.DormService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DormServiceImpl implements DormService {
    private DormDao dormDao=new DormDaoImpl();
    private static Logger logger=Logger.getLogger(DormServiceImpl.class);
    private static int recordNum;
    @Override
    public int addDorm(Dorm dorm) {
        if(dorm!=null&&dorm.getAllStu()<=40){
            try {
                recordNum=dormDao.AddDorm(dorm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return recordNum;
    }

    @Override
    public int deleteDorm(String dorm_Num) {
        try {
            recordNum=dormDao.deleteDorm(dorm_Num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordNum;
    }

    @Override
    public int updateDorm(Dorm dorm) {

        try {
            recordNum=dormDao.updateDorm(dorm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordNum;
    }

    @Override
    public List<Dorm> getAllDorm() {
        List<Dorm> dorms=null;
        try {
            dorms=dormDao.getAllDorm();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dorms;
    }

    @Override
    public Dorm getDormByNum(String dorm_Num) {
        Dorm dorm=null;
        try {
            dorm=dormDao.getDormByDormNum(dorm_Num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dorm;
    }
}
