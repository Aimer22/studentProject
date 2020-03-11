package com.cn.service;




import com.cn.domain.Tuition;

import java.util.List;

public interface TuitionService {
    int addTuition(Tuition tuition);

    int deleteTuition(String stuId);

    int updateTuition(Tuition tuition);

    List<Tuition> getAllTuition();

    Tuition getTuitionBystuId(String stuId);

    Tuition getTuitionByPayer(String payer);
}
