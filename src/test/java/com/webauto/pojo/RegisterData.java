package com.webauto.pojo;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 15:20
 */
public class RegisterData {
    private String isNegative;
    private String desc;
    private String mobilePhone;
    private String password;
    private String passwordConfirm;
    private String verifyCode;
    private String errorMsg;

    public RegisterData() {
        super();
    }

    public RegisterData(String isNegative, String desc, String mobilePhone, String password, String passwordConfirm, String verifyCode, String errorMsg) {
        this.isNegative = isNegative;
        this.desc = desc;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.verifyCode = verifyCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "RegisterData{" + "isNegative='" + isNegative + '\'' + ", desc='" + desc + '\'' + ", mobilePhone='" + mobilePhone + '\'' + ", password='" + password + '\'' + ", passwordConfirm='" + passwordConfirm + '\'' + ", verifyCode='" + verifyCode + '\'' + ", errorMsg='" + errorMsg + '\'' + '}';
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
