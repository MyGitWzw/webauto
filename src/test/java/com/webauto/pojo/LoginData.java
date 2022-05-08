package com.webauto.pojo;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 16:32
 */
public class LoginData {
    private String isNegative;
    private String desc;
    private String mobilePhone;
    private String password;
    private String errorMsg;

    public LoginData() {
    }

    public LoginData(String isNegative, String desc, String mobilePhone, String password, String errorMsg) {
        this.isNegative = isNegative;
        this.desc = desc;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "LoginData{" + "isNegative='" + isNegative + '\'' + ", desc='" + desc + '\'' + ", mobilePhone='" + mobilePhone + '\'' + ", password='" + password + '\'' + ", errorMsg='" + errorMsg + '\'' + '}';
    }

    public String getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(String isNegative) {
        this.isNegative = isNegative;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
