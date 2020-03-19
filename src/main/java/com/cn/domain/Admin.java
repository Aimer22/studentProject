package com.cn.domain;

import java.sql.Timestamp;

public class Admin {
    private Integer adminId;
    private String adminUsername;
    private String adminPassword;
    private Integer flag;
    private Boolean ifUse;
    private Timestamp registTimes;
    private Timestamp loginTimes;

    public Admin() {
    }

    public Admin(Integer adminId, String adminUsername, String adminPassword, Integer flag, Boolean ifUse, Timestamp registTimes, Timestamp loginTimes) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flag = flag;
        this.ifUse = ifUse;
        this.registTimes = registTimes;
        this.loginTimes = loginTimes;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    public Boolean getIfUse() {
        return ifUse;
    }

    public void setIfUse(Boolean ifUse) {
        this.ifUse = ifUse;
    }

    public Timestamp getRegistTimes() {
        return registTimes;
    }

    public void setRegistTimes(Timestamp registTimes) {
        this.registTimes = registTimes;
    }

    public Timestamp getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Timestamp loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", flag=" + flag +
                ", ifUse=" + ifUse +
                ", registTimes=" + registTimes +
                ", loginTimes=" + loginTimes +
                '}';
    }
}
