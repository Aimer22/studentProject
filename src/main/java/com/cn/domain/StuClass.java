package com.cn.domain;

import java.io.Serializable;

public class StuClass implements Serializable {

    private String class_Id;
    private Integer stu_Count;
    private Integer max_Num;
    private Integer tea_Id;

    public StuClass() {
    }

    public StuClass(String class_Id, Integer stu_Count, Integer max_Num, Integer tea_Id) {
        this.class_Id = class_Id;
        this.stu_Count = stu_Count;
        this.max_Num = max_Num;
        this.tea_Id = tea_Id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public Integer getStu_Count() {
        return stu_Count;
    }

    public void setStu_Count(Integer stu_Count) {
        this.stu_Count = stu_Count;
    }

    public Integer getMax_Num() {
        return max_Num;
    }

    public void setMax_Num(Integer max_Num) {
        this.max_Num = max_Num;
    }

    public Integer getTea_Id() {
        return tea_Id;
    }

    public void setTea_Id(Integer tea_Id) {
        this.tea_Id = tea_Id;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "class_Id='" + class_Id + '\'' +
                ", stu_Count=" + stu_Count +
                ", max_Num=" + max_Num +
                ", tea_Id='" + tea_Id + '\'' +
                '}';
    }
}
