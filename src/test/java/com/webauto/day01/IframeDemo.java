package com.webauto.day01;

import com.webauto.cases.Base;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.Arrays;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/19 15:35
 */
public class IframeDemo extends Base {
    @Test
    public void test() throws InterruptedException {
        driver.get("file:///C:/Users/wzw/Desktop/Lemon/4.%20web%20auto/73.%20Special%20WebElement%20alert,%20iframe/a.html");
        driver.findElement(By.id("aa")).sendKeys("a");
        Thread.sleep(3000);
        int[] a = new int[10];
        Arrays.fill(a,1);


        //切换到 b.html
        driver.switchTo().frame("bframe");
        driver.findElement(By.id("bb")).sendKeys("b");

        //再切换到 a.html, ，
        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame(); // 在这个例子中,与 driver.switchTo().parentFrame(); 都可以实现相同功能
        driver.findElement(By.id("aa")).sendKeys("hello");
        Thread.sleep(3000);
    }
}
