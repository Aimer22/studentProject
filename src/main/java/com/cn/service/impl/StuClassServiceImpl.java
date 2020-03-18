package com.cn.service.impl;

import com.cn.dao.StuClassDao;
import com.cn.dao.impl.StuClassDaoImpl;
import com.cn.domain.StuClass;
import com.cn.service.StuClassService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;


public class StuClassServiceImpl implements StuClassService {
    private StuClassDao stuClassDao=new StuClassDaoImpl();
    private static Logger logger=Logger.getLogger(StuClassServiceImpl.class);
    private static int recordNum;
    @Override
    public int addStuClass(StuClass stuClass) {
        if (stuClass!=null){
            try {
                recordNum=stuClassDao.addStuClass(stuClass);
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return recordNum;
    }

    @Override
    public int deleteClass(String class_Id) {
        if (class_Id!=null&&class_Id.length()==7){
            try {
                recordNum = stuClassDao.deleteClass(class_Id);
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return recordNum;
    }

    @Override
    public int updateClass(StuClass stuClass) {
        if (stuClass!=null){
            try {
                recordNum = stuClassDao.updateClass(stuClass);
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return recordNum;
    }

    @Override
    public List<StuClass> getAllClass() {
        List<StuClass> stuClasses = null;
        try {
            stuClasses = stuClassDao.getAllClass();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return stuClasses;
    }

    @Override
    public StuClass getClassById(String class_Id) {
        StuClass stuClass=null;
        if (class_Id!=null){
            try {
                stuClass = stuClassDao.getClassById(class_Id);
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return stuClass;
    }
}
