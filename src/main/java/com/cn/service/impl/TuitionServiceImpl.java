package com.cn.service.impl;

import com.cn.dao.TuitionDao;
import com.cn.dao.impl.TuitionDaoImpl;
import com.cn.domain.Tuition;
import com.cn.service.TuitionService;
import org.apache.log4j.Logger;

import java.util.List;

public class TuitionServiceImpl implements TuitionService {
    private TuitionDao tuitionDao=new TuitionDaoImpl();
    private static Logger logger=Logger.getLogger(TuitionServiceImpl.class);
    @Override
    public int addTuition(Tuition tuition) {
        int recordNum=0;
        if(tuition!=null){
            try {
                recordNum=tuitionDao.addTuition(tuition);
            } catch (Exception e){
                logger.error(e.toString());
            }
        }
        return recordNum;
    }

    @Override
    public int deleteTuition(int stuNo) {
        int recordNum=0;
        if(stuNo!=0){
            try {
                recordNum=tuitionDao.deleteTuition(stuNo);
            } catch (Exception e){
                logger.error(e.toString());
            }
        }
        return recordNum;
    }

    @Override
    public int updateTuition(Tuition tuition) {
        int recordNum=0;
        if(tuition!=null){
            try {
                recordNum=tuitionDao.updateTuition(tuition);
            } catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }
        return recordNum;
    }

    @Override
    public List<Tuition> getAllTuition() {
        List<Tuition> tuitionList=null;

            try {
                tuitionList=tuitionDao.getAllTuition();
            } catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        return tuitionList;
    }

    @Override
    public Tuition getTuitionBystuNo(int stuNo) {
        Tuition tuition=null;
        if(stuNo!=0){
            try {
                tuition=tuitionDao.getTuitionByStuNo(stuNo);
            }catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }else{
            logger.info("Tuition中stuNo为空");
        }
        return tuition;
    }
}
