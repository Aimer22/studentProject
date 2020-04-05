package com.cn.domain;

import java.sql.Timestamp;

public class Tuition {
    private Integer orderNo;
    private String payer;
    private Integer fees;
    private Integer spendOnBook;
    private Integer accommodation;
    private Integer insurance;
    private Integer amount;
    private Timestamp timeOfPay;
    private boolean stateOfPay;
    private Integer stuNo;

    public Tuition() {
    }

    public Tuition(Integer orderNo, String payer, Integer fees, Integer spendOnBook, Integer accommodation, Integer insurance, Integer amount, Timestamp timeOfPay, boolean stateOfPay, Integer stuNo) {
        this.orderNo = orderNo;
        this.payer = payer;
        this.fees = fees;
        this.spendOnBook = spendOnBook;
        this.accommodation = accommodation;
        this.insurance = insurance;
        this.amount = amount;
        this.timeOfPay = timeOfPay;
        this.stateOfPay = stateOfPay;
        this.stuNo = stuNo;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
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

    public Timestamp getTimeOfPay() {
        return timeOfPay;
    }

    public void setTimeOfPay(Timestamp timeOfPay) {
        this.timeOfPay = timeOfPay;
    }

    public boolean isStateOfPay() {
        return stateOfPay;
    }

    public void setStateOfPay(boolean stateOfPay) {
        this.stateOfPay = stateOfPay;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "Tuition{" +
                "orderNo=" + orderNo +
                ", payer='" + payer + '\'' +
                ", fees=" + fees +
                ", spendOnBook=" + spendOnBook +
                ", accommodation=" + accommodation +
                ", insurance=" + insurance +
                ", amount=" + amount +
                ", timeOfPay=" + timeOfPay +
                ", stateOfPay=" + stateOfPay +
                ", stuNo=" + stuNo +
                '}';
    }
}
