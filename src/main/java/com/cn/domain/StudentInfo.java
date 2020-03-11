package com.cn.domain;

import java.sql.Timestamp;

public class StudentInfo {
	private Integer stuInfoNo;
	private String userName;
	private String stuId;
	private String stuName;
	private String sex;
	private Integer age;
	private	String birthPlace;
	private String national;
	private String campus;
	private String major;
	private String stuClass;
	private String dormitory;
	private String phone;
	private boolean ifPay;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStuInfoNo() {
		return stuInfoNo;
	}
	public void setStuInfoNo(Integer stuInfoNo) {
		this.stuInfoNo = stuInfoNo;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
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
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
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

	
	public StudentInfo() {
		
	}

	@Override
	public String toString() {
		return "StudentInfo{" +
				"stuInfoNo=" + stuInfoNo +
				", userName='" + userName + '\'' +
				", stuId='" + stuId + '\'' +
				", stuName='" + stuName + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", birthPlace='" + birthPlace + '\'' +
				", national='" + national + '\'' +
				", campus='" + campus + '\'' +
				", major='" + major + '\'' +
				", stuClass='" + stuClass + '\'' +
				", dormitory='" + dormitory + '\'' +
				", phone='" + phone + '\'' +
				", ifPay=" + ifPay +
				'}';
	}

	public StudentInfo(Integer stuInfoNo, String userName, String stuId, String stuName, String sex, Integer age, String birthPlace, String national, String campus, String major, String stuClass, String dormitory, String phone, boolean ifPay) {
		this.stuInfoNo = stuInfoNo;
		this.userName = userName;
		this.stuId = stuId;
		this.stuName = stuName;
		this.sex = sex;
		this.age = age;
		this.birthPlace = birthPlace;
		this.national = national;
		this.campus = campus;
		this.major = major;
		this.stuClass = stuClass;
		this.dormitory = dormitory;
		this.phone = phone;
		this.ifPay = ifPay;
	}
}
