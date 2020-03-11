package com.cn.dao;




import com.cn.domain.Tuition;

import java.sql.SQLException;
import java.util.List;

public interface TuitionDao {
    int addTuition(Tuition tuition) throws SQLException;

    int deleteTuition(String stuId) throws SQLException;

    int updateTuition(Tuition tuition) throws SQLException;

    List<Tuition> getAllTuition() throws SQLException;

    Tuition getTuitionByStuId(String stuId) throws SQLException;

    Tuition getTuitionByPayer(String payer) throws SQLException;
}
