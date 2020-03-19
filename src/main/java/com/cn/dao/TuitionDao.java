package com.cn.dao;




import com.cn.domain.Tuition;

import java.sql.SQLException;
import java.util.List;

public interface TuitionDao {
    int addTuition(Tuition tuition) throws SQLException;

    int deleteTuition(int stuNo) throws SQLException;

    int updateTuition(Tuition tuition) throws SQLException;

    List<Tuition> getAllTuition() throws SQLException;

    Tuition getTuitionByStuNo(int stuNo) throws SQLException;


}
