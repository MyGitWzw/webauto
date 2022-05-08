package com.webauto.day01;

import com.webauto.cases.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/19 14:45
 */
public class ModalDemo extends Base {

    @Test
    public void test() throws InterruptedException {
        driver.get("file:///C:/Users/wzw/Desktop/Lemon/4.%20web%20auto/73.%20Special%20WebElement%20alert,%20iframe/alert_confirm.html");
        // 点击登录按钮
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        // 切换到 alert 模态框，accept()表示点击确定
        driver.switchTo().alert().accept();

        //点击重置按钮
        driver.findElement(By.id("reset")).click();
        Thread.sleep(5000);
         //切换到 alert 模态框，dismiss()表示点击取消
        driver.switchTo().alert().dismiss();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));


    }
}
