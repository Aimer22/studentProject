package com.cn.domain;

import java.sql.Timestamp;

public class StudentInfo {
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
	private Integer stuNo;  //外键


	public StudentInfo(Integer stuId, String sex, Integer age, String birthPlace, String national, String campus, String major, String stuClass, String dorm, String phone, boolean ifPay, Integer stuNo) {
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
		this.stuNo = stuNo;
	}

	public StudentInfo() {
		
	}

	@Override
	public String toString() {
		return "StudentInfo{" +
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
				", stuNo=" + stuNo +
				'}';
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

	public Integer getStuNo() {
		return stuNo;
	}

	public void setStuNo(Integer stuNo) {
		this.stuNo = stuNo;
	}
}
