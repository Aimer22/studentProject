package com.cn.domain;

import java.sql.Timestamp;

public class Tuition {
    private Integer orderNo;
    private String stuId;
    private String payer;
    private Integer fees;
    private Integer spendOnBook;
    private Integer accommodation;
    private Integer insurance;
    private Integer amount;
    private Timestamp payTime;
    private boolean stateOfPay;

    public Tuition() {
    }

    public Tuition(Integer orderNo, String stuId, String payer, Integer fees, Integer spendOnBook, Integer accommodation, Integer insurance, Integer amount, Timestamp payTime, boolean stateOfPay) {
        this.orderNo = orderNo;
        this.stuId = stuId;
        this.payer = payer;
        this.fees = fees;
        this.spendOnBook = spendOnBook;
        this.accommodation = accommodation;
        this.insurance = insurance;
        this.amount = amount;
        this.payTime = payTime;
        this.stateOfPay = stateOfPay;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Integer getSpendOnBook() {
        return spendOnBook;
    }

    public void setSpendOnBook(Integer spendOnBook) {
        this.spendOnBook = spendOnBook;
    }

    public Integer getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Integer accommodation) {
        this.accommodation = accommodation;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public boolean isStateOfPay() {
        return stateOfPay;
    }

    public void setStateOfPay(boolean stateOfPay) {
        this.stateOfPay = stateOfPay;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Tuition{" +
                "orderNo=" + orderNo +
                ", stuId='" + stuId + '\'' +
                ", payer='" + payer + '\'' +
                ", fees=" + fees +
                ", spendOnBook=" + spendOnBook +
                ", accommodation=" + accommodation +
                ", insurance=" + insurance +
                ", amount=" + amount +
                ", payTime=" + payTime +
                ", stateOfPay=" + stateOfPay +
                '}';
    }
}
