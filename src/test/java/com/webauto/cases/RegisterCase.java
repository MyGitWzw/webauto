package com.webauto.cases;

import com.webauto.assertion.Assertion;
import com.webauto.util.RegisterUtil;
import com.webauto.util.UILibraryUtil;
import com.webauto.util.VerifyCodeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 14:44
 */
public class RegisterCase extends Base {
    /**
     * 测试注册模块的所有反向用例
     *@param mobilePhone
     * @param password
     * @param pwdConfirm
     * @param verifyCode
     * @param expectedData
     * */

    @Test(dataProvider = "negativeDatas")
    public void testNegativeCases(String mobilePhone, String password, String pwdConfirm,String verifyCode,String expectedData){
        // 访问注册页面
        driver.get("http://39.108.136.60：8085/lmcanon_web_auto/mng/register.html");// for example

        // 手机号
        UILibraryUtil.getElementByKeyword("注册页面","手机号").sendKeys(mobilePhone);
        //密码
        UILibraryUtil.getElementByKeyword("注册页面","密码").sendKeys(mobilePhone);

        // 确认密码
        UILibraryUtil.getElementByKeyword("注册页面","确认密码").sendKeys(mobilePhone);
        // 验证码
        UILibraryUtil.getElementByKeyword("注册页面","验证码").sendKeys(mobilePhone);

        // 点击注册按钮
//        driver.findElement(By.id("signup-button")).click();
        UILibraryUtil.getElementByKeyword("注册页面","注册按钮").click();

        //获取错误提示 并进行断言
        WebElement elementByKeyword = UILibraryUtil.getElementByKeyword("注册页面", "展示错误信息的元素");
//        String actual = elementByKeyword.getText();
////        String actual = driver.findElement(By.cssSelector("p.tips")).getText();
//        Assert.assertEquals(actual,expectedData);

        Assertion.assertTextPresent(elementByKeyword,expectedData);
    }

    @DataProvider
    public Object[][] negativeDatas(){
        String [] cellNames = {"MobilePhone","Password","PasswordConfirm","VerifyCode","ErrorMsg"};
        Object[][] datas = RegisterUtil.getDatas("0",cellNames);
        return datas;
    }

    /**
     * 测试注册模块的所有正向用例
     *@param mobilePhone
     * @param password
     * @param pwdConfirm
     * */

    @Test(dataProvider = "positiveDatas")
    public void testPositiveCases(String mobilePhone, String password, String pwdConfirm){
        // 访问注册页面
        driver.get("http://39.108.136.60：8085/lmcanon_web_auto/mng/register.html");// for example
        // 手机号
        UILibraryUtil.getElementByKeyword("注册页面","手机号").sendKeys(mobilePhone);
        //密码
        UILibraryUtil.getElementByKeyword("注册页面","密码").sendKeys(mobilePhone);
        // 确认密码
        UILibraryUtil.getElementByKeyword("注册页面","确认密码").sendKeys(mobilePhone);
        // 验证码
//        driver.findElement(By.id("verifycode")).sendKeys(VerifyCodeUtil.getVerifyCode());
        UILibraryUtil.getElementByKeyword("注册页面","验证码").sendKeys(mobilePhone);
        // 点击注册按钮
        UILibraryUtil.getElementByKeyword("注册页面","注册按钮").click();

        //获取错误提示 并 进行断言
        String urlContains = "login.html";
//        String currentUrl = driver.getCurrentUrl();
//        Boolean isLoginPage = true;
//        if(currentUrl.contains(urlContains)){
//            isLoginPage = false;
//        }
//        Assert.assertTrue(isLoginPage);
        Assertion.assertUrlContains(urlContains);
    }

    @DataProvider
    public Object[][] positiveDatas(){
        String [] cellNames = {"MobilePhone","Password","PasswordConfirm"};
        Object[][] datas = RegisterUtil.getDatas("1",cellNames);
        return datas;
    }
}
