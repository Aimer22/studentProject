package com.cn.dao;

import com.cn.domain.Dorm;

import java.sql.SQLException;
import java.util.List;

public interface DormDao {
    int AddDorm(Dorm dorm) throws SQLException;

    int deleteDorm(String dorm_Num) throws SQLException;

    int updateDorm(Dorm dorm) throws SQLException;

    List<Dorm> getAllDorm() throws SQLException;

    Dorm getDormByDormNum(String dorm_Num) throws SQLException;
}
