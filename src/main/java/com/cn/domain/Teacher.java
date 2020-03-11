package com.cn.domain;

import java.sql.Timestamp;

public class Teacher {
	private Integer teaId;
	private String teaName;
	private String tuserName;
	private String tpassWord;
	private String tClass;
	private Timestamp registrationTimes;
	private Timestamp loginTimes;
	private boolean ifUse;
	private Integer flag;
	
	
	
	public Teacher() {
		super();
		
	}
	
	public Teacher(Integer teaId, String teaName, String tuserName, String tpassWord, String tClass,
			Timestamp registrationTimes, Timestamp loginTimes, boolean ifUse, Integer flag) {		
		this.teaId = teaId;
		this.teaName = teaName;
		this.tuserName = tuserName;
		this.tpassWord = tpassWord;
		this.tClass = tClass;
		this.registrationTimes = registrationTimes;
		this.loginTimes = loginTimes;
		this.ifUse = ifUse;
		this.flag = flag;
	}
	public Teacher(String teaName, String tuserName, String tpassWord, String tClass,
			Timestamp registrationTimes, Timestamp loginTimes, boolean ifUse, Integer flag) {				
		this.teaName = teaName;
		this.tuserName = tuserName;
		this.tpassWord = tpassWord;
		this.tClass = tClass;
		this.registrationTimes = registrationTimes;
		this.loginTimes = loginTimes;
		this.ifUse = ifUse;
		this.flag = flag;
	}
	public Teacher(Integer teaId,String tuserName, String tpassWord, String tClass,
			Timestamp registrationTimes, Timestamp loginTimes, boolean ifUse, Integer flag) {		
		this.teaId = teaId;
		this.tuserName = tuserName;
		this.tpassWord = tpassWord;
		this.tClass = tClass;
		this.registrationTimes = registrationTimes;
		this.loginTimes = loginTimes;
		this.ifUse = ifUse;
		this.flag = flag;
	}

	public Integer getTeaId() {
		return teaId;
	}
	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTuserName() {
		return tuserName;
	}
	public void setTuserName(String tuserName) {
		this.tuserName = tuserName;
	}
	public String getTpassWord() {
		return tpassWord;
	}
	public void setTpassWord(String tpassWord) {
		this.tpassWord = tpassWord;
	}
	public String gettClass() {
		return tClass;
	}
	public void settClass(String tClass) {
		this.tClass = tClass;
	}
	public Timestamp getRegistrationTimes() {
		return registrationTimes;
	}
	public void setRegistrationTimes(Timestamp registrationTimes) {
		this.registrationTimes = registrationTimes;
	}
	public Timestamp getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Timestamp loginTimes) {
		this.loginTimes = loginTimes;
	}
	public boolean isIfUse() {
		return ifUse;
	}
	public void setIfUse(boolean ifUse) {
		this.ifUse = ifUse;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", teaName=" + teaName + ", tuserName=" + tuserName + ", tpassWord="
				+ tpassWord + ", tClass=" + tClass + ", registrationTimes=" + registrationTimes + ", loginTimes="
				+ loginTimes + ", ifUse=" + ifUse + ", flag=" + flag + "]";
	}
	
	
	
	
	
}
