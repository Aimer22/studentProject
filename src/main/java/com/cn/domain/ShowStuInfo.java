package com.cn.domain;

public class ShowStuInfo {
    private Integer stuId;
    private String sex;
    private Integer age;
    private	String birthPlace;
    private String national;
    private String campus;
    private String major;
    private String stuClass;	//外键
    private String dorm;		//外键
    private String phone;
    private boolean ifPay;
    private String stuName;

    public ShowStuInfo(Integer stuId, String sex, Integer age, String birthPlace, String national, String campus, String major, String stuClass, String dorm, String phone, boolean ifPay, String stuName) {
        this.stuId = stuId;
        this.sex = sex;
        this.age = age;
        this.birthPlace = birthPlace;
        this.national = national;
        this.campus = campus;
        this.major = major;
        this.stuClass = stuClass;
        this.dorm = dorm;
        this.phone = phone;
        this.ifPay = ifPay;
        this.stuName = stuName;
    }

    public ShowStuInfo() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIfPay() {
        return ifPay;
    }

    public void setIfPay(boolean ifPay) {
        this.ifPay = ifPay;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "ShowStuInfo{" +
                "stuId=" + stuId +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthPlace='" + birthPlace + '\'' +
                ", national='" + national + '\'' +
                ", campus='" + campus + '\'' +
                ", major='" + major + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", dorm='" + dorm + '\'' +
                ", phone='" + phone + '\'' +
                ", ifPay=" + ifPay +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
