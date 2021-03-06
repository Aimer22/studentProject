package com.cn.service.impl;

import com.cn.dao.StudentInfoDao;
import com.cn.dao.impl.StudentInfoDaoImpl;
import com.cn.domain.ShowStuInfo;
import com.cn.domain.StudentInfo;
import com.cn.service.StudentInfoService;
import org.apache.log4j.Logger;


import java.util.List;


public class StudentInfoServiceImpl implements StudentInfoService {
    private StudentInfoDao studentInfoDao=new StudentInfoDaoImpl();
    private static Logger logger=Logger.getLogger(StudentInfoServiceImpl.class);

    @Override
    public int addStudentInfo(StudentInfo studentInfo){
        int recordNum=0;
        if(studentInfo !=null){
            try {
                recordNum=studentInfoDao.addStudentInfo(studentInfo);
            } catch (Exception e){
                logger.error(e.toString());
            }
        }
            return recordNum;
        }

    @Override
    public int deleteStuInfo(int stuId){
        int recordNum=0;
        if(stuId !=0){
            try {
                recordNum=studentInfoDao.deleteStudentInfo(stuId);
            } catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }
        return recordNum;
    }


    @Override
    public int updateStuInfo(StudentInfo studentInfo){
        int recordNum=0;
        if(studentInfo !=null){
            try {
                recordNum=studentInfoDao.update(studentInfo);
            } catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }
        return recordNum;
    }


    @Override
    public List<StudentInfo> getAllStuInfo(){
        List<StudentInfo> list=null;
        try {
            list=studentInfoDao.getAllStudentInfo();
        }catch(Exception e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ShowStuInfo> showAllStuInfo() {
        List<ShowStuInfo> list=null;
        try {
            list=studentInfoDao.ShowAllStuInfo();
        }catch(Exception e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public StudentInfo getStuInfoById(int stuId){
        StudentInfo studentInfo=null;
        if(stuId!=0){
            try {
                studentInfo=studentInfoDao.getStuInfoByStuId(stuId);
            }catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }else{
            logger.info("StudentInfo中stuId为空");
        }
        return studentInfo;
    }

    @Override
    public StudentInfo getStuInfoByNo(int stuNo){
        StudentInfo studentInfo=null;
        if(stuNo!=0){
            try {
                studentInfo=studentInfoDao.getStuInfoByStuNo(stuNo);
            }catch (Exception e){
                logger.error(e.toString());
                e.printStackTrace();
            }
        }else{
            logger.info("StudentInfo中stuNo为空");
        }
        return studentInfo;
    }


}
