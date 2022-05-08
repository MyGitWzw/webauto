package com.webauto.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/17 15:21
 */
public class ChromeDemo {

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:/Program Files/chromedriver_win32/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        //get()方法，访问指定的url
        String url = "https://www.baidu.com";
        driver.get(url);

        WebDriverWait webDriverWait1 = new WebDriverWait(driver,10L,1L);

        //输入待搜索的内容，比如：柠檬学院，
        driver.findElement(By.id("kw")).sendKeys("柠檬学院");

        //点击'百度一下' 按钮,id = su is the web element of click button
        driver.findElement(By.id("su")).click();



        // driver.manage().window() 获取window对象,窗口最大化
//        Window window = driver.manage().window();
//        window.maximize();
//        Thread.sleep(2000);
//        window.setPosition(new Point(100,200));
//        Thread.sleep(2000);
//        window.setSize(new Dimension(222,333));
//
//        //get()方法，访问指定的url
//        String url = "https://www.baidu.com";
//        driver.get(url);
//
//        // driver.navigate() 获取 Navigation 对象
//
//        driver.navigate().to(url); //me with driver.get(url);
//
//
//        WebDriverWait webDriverWait1 = new WebDriverWait(driver,10L,1L);
//
//        //输入待搜索的内容，比如：柠檬学院，
//        driver.findElement(By.id("kw")).sendKeys("柠檬学院");
//
//        //点击'百度一下' 按钮,id = su is the web element of click button
//        driver.findElement(By.id("su")).click();
//        List<WebElement> elements = driver.findElements(By.className(""));
////        List<WebElement> elements2 = driver.findElements(By.partialLinkText());
//        driver.findElements(By.xpath(""));
//
//        // 1. 根据id 来定位元素
//
//        // 2. 根据 name 来定位元素
//
//        // 3. 根据 tagName
//
//        // 4. linkText
//        // 5. partialLinkText
//        // 6. cssSelector
//
//        driver.findElements(By.)
//
//
//
//        Thread.sleep(10000);
//        driver.quit(); // same as the Base.java driver.quit();



    }
}
