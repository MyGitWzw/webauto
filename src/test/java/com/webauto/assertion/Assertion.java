package com.webauto.assertion;

import com.webauto.cases.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**断言类库：自定义多种场景的断言方法
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 15:54
 */
public class Assertion {


    public static void assertUrlContains(String urlContains){
        WebDriverWait wait = new WebDriverWait(Base.driver, 20);
        boolean isDirectedToLogin = true;
        try {
            Boolean until = wait.until(ExpectedConditions.urlContains(urlContains));
        } catch (Exception e) {
            isDirectedToLogin = false;
        }
        Assert.assertTrue(isDirectedToLogin);
    }

    public static void assertTextPresent(WebElement element,String text){
        WebDriverWait wait = new WebDriverWait(Base.driver, 20);
        boolean isTextPresent = true;
        try{
            wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        }catch (Exception e){
            isTextPresent = false;
        }
        Assert.assertTrue(isTextPresent);
    }

    public static void assertElementToBeClickable(WebElement element){

        WebDriverWait wait = new WebDriverWait(Base.driver, 20);
        boolean isClickable = true;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            isClickable = false;
        }
        Assert.assertTrue(isClickable);
    }

}
