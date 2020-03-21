package com.cn.service;




import com.cn.domain.Tuition;

import java.util.List;

public interface TuitionService {
    int addTuition(Tuition tuition);

    int deleteTuition(int stuNo);

    int updateTuition(Tuition tuition);

    List<Tuition> getAllTuition();

    Tuition getTuitionBystuNo(int stuNo);

}
