package com.cn.domain;

import java.sql.Timestamp;

public class Student {
	private Integer stuNo;
	private String stuName;
	private String username;
	private String password;
	private Timestamp registerTime;
	private Timestamp loginTime;
	private boolean ifUse;
	private boolean if_finished_firstStep;
	private boolean if_finished_secondStep;
	
	
	public Student() {
		
	}

	public Student(Integer stuNo, String stuName, String username, String password, Timestamp registerTime, Timestamp loginTime, boolean ifUse, boolean if_finished_firstStep, boolean if_finished_secondStep) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.username = username;
		this.password = password;
		this.registerTime = registerTime;
		this.loginTime = loginTime;
		this.ifUse = ifUse;
		this.if_finished_firstStep = if_finished_firstStep;
		this.if_finished_secondStep = if_finished_secondStep;
	}

	public Integer getStuNo() {
		return stuNo;
	}




	public void setStuNo(Integer stuNo) {
		this.stuNo = stuNo;
	}




	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getUsername() {
		return username;
	}

	public boolean isIfUse() {
		return ifUse;
	}

	public void setIfUse(boolean ifUse) {
		this.ifUse = ifUse;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public boolean isIf_finished_firstStep() {
		return if_finished_firstStep;
	}

	public void setIf_finished_firstStep(boolean if_finished_firstStep) {
		this.if_finished_firstStep = if_finished_firstStep;
	}

	public boolean isIf_finished_secondStep() {
		return if_finished_secondStep;
	}

	public void setIf_finished_secondStep(boolean if_finished_secondStep) {
		this.if_finished_secondStep = if_finished_secondStep;
	}

	@Override
	public String toString() {
		return "Student{" +
				"stuNo=" + stuNo +
				", stuName='" + stuName + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", registerTime=" + registerTime +
				", loginTime=" + loginTime +
				", ifUse=" + ifUse +
				", if_finished_firstStep=" + if_finished_firstStep +
				", if_finished_secondStep=" + if_finished_secondStep +
				'}';
	}
}
