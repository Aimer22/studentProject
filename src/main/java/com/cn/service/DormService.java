package com.cn.service;

import com.cn.domain.Dorm;

import java.util.List;

public interface DormService {
    int addDorm(Dorm dorm);

    int deleteDorm(String dorm_Num);

    int updateDorm(Dorm dorm);

    List<Dorm> getAllDorm();

    Dorm getDormByNum(String dorm_Num);
}
