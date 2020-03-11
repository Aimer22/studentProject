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
    public int deleteTuition(String stuId) {
        int recordNum=0;
        if(stuId!=null){
            try {
                recordNum=tuitionDao.deleteTuition(stuId);
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
    public Tuition getTuitionBystuId(String stuId) {
        Tuition tuition=null;
        if(stuId!=null){
            try {
                tuition=tuitionDao.getTuitionByStuId(stuId);
            }catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }else{
            logger.info("Tuition中stuId为空");
        }
        return tuition;
    }

    @Override
    public Tuition getTuitionByPayer(String payer) {
        Tuition tuition=null;
        if(payer!=null){
            try {
                tuition=tuitionDao.getTuitionByPayer(payer);
            }catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }else{
            logger.info("Tuition中payer为空");
        }
        return tuition;
    }
}
