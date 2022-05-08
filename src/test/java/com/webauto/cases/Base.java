package com.webauto.cases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/17 15:44
 */
public class Base {
    public static WebDriver driver;
    @Parameters(value = {"broswerTyep"})
    @BeforeTest
    public void initBrowser(String broswerTyep) throws InterruptedException {
        System.out.println("浏览器类型："+ broswerTyep);

        if("chrome".equalsIgnoreCase(broswerTyep)){
            System.setProperty("webdriver.chrome.driver", "E:/Program Files/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        }else{
            System.out.println("not supported, please check browser type if ie,firefox or chrome. ");
        }
    }

    @AfterSuite
    public void tearDown(){

        driver.quit();
    }

}
