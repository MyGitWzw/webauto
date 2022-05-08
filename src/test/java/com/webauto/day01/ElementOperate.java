package com.webauto.day01;

import com.webauto.cases.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/18 22:23
 */
public class ElementOperate extends Base {

    @Test
    public  void test() throws InterruptedException {
        driver.get("file:///C:/Users/wzw/Desktop/Lemon/4.%20web%20auto/73.%20Special%20WebElement%20alert,%20iframe/demo.html");
//        Thread.sleep(5000);
        System.out.println("用户名输入框是否可见："+driver.findElement(By.id("username")).isDisplayed());
        System.out.println("博客输入框是否可编辑："+driver.findElement(By.id("blog")).isEnabled());

        //定位到select 下拉框，并封装成Select 类型的对象
        Select select = new Select(driver.findElement(By.tagName("select")));
        //获取Select对象下的所有option选项
        List<WebElement> options = select.getOptions();
        for (WebElement option:options ) {
            if("女性".equals(option.getText())){
                System.out.println("女性选项是否被选中："+option.isSelected());
            }
        }


    }
}
