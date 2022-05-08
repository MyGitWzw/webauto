package com.webauto.util;

import com.webauto.cases.Base;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 20:59
 */
public class VerifyCodeUtil {
    public static final String COOKIE_NAME = "verifycode";
    public static String getVerifyCode(){
        return Base.driver.manage().getCookieNamed(COOKIE_NAME).getValue();
    }
}
