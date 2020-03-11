package com.cn.domain;

public class Dorm {
    private String dorm_Num;
    private String dorm_Sex;
    private Integer allStu;
    private Integer livedNum;

    public Dorm() {
    }

    public Dorm(String dorm_Num, String dorm_Sex, Integer allStu, Integer livedNum) {
        this.dorm_Num = dorm_Num;
        this.dorm_Sex = dorm_Sex;
        this.allStu = allStu;
        this.livedNum = livedNum;
    }

    public String getDorm_Num() {
        return dorm_Num;
    }

    public void setDorm_Num(String dorm_Num) {
        this.dorm_Num = dorm_Num;
    }

    public String getDorm_Sex() {
        return dorm_Sex;
    }

    public void setDorm_Sex(String dorm_Sex) {
        this.dorm_Sex = dorm_Sex;
    }

    public Integer getAllStu() {
        return allStu;
    }

    public void setAllStu(Integer allStu) {
        this.allStu = allStu;
    }

    public Integer getLivedNum() {
        return livedNum;
    }

    public void setLivedNum(Integer livedNum) {
        this.livedNum = livedNum;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dorm_Num='" + dorm_Num + '\'' +
                ", dorm_Sex='" + dorm_Sex + '\'' +
                ", allStu=" + allStu +
                ", livedNum=" + livedNum +
                '}';
    }
}
