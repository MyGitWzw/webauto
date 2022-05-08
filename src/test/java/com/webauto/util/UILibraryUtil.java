package com.webauto.util;

import com.webauto.cases.Base;
import com.webauto.pojo.Page;
import com.webauto.pojo.UIElement;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.attribute.standard.PagesPerMinute;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 10:37
 */
public class UILibraryUtil {
    public static List<Page> pages = new ArrayList<Page>();

    static {
        loadPages(PropertiesUtil.properties.getProperty("uiLibrary.path"));
    }

    /****
     * 解析 UILibrary.xml
     *@param uiLibraryPath : the path of UILibrary.xml which stores in config.properties with key "uiLibrary.path"
     */

    private static void loadPages(String uiLibraryPath) {// 解析xml 的步骤
        /** 获取解析器*/
        SAXReader reader = new SAXReader();
        InputStream inputStream = null;
        try {

            inputStream = new FileInputStream(new File(uiLibraryPath));
            /**拿到Document对象*/
             Document document = reader.read(inputStream);
            /**获取根元素*/
            Element rootElement = document.getRootElement();

            List<Element> pageElements = rootElement.elements("Page");
            /**遍历子元素 处理每一个 <Page元素>*/
            for (Element pageElement : pageElements) {
                String pageKeyword = pageElement.attributeValue("keyword");
                /**获取<Page> 元素的子元素 <UIElement>并保存到 uiElements集合*/
                List<Element> uiElements = pageElement.elements("UIElement");

                ArrayList<UIElement> uiElementsList = new ArrayList<UIElement>();
                /**遍历 <UIElement> 元素，解析封装成 UIElement类型的对象，再保存到 uiElementsList 中*/
                for (Element uiElement : uiElements) {
                    String keyword = uiElement.attributeValue("keyword");
                    String id = uiElement.attributeValue("id");
                    String value = uiElement.attributeValue("value");
                    UIElement uiEle = new UIElement(keyword, id, value);
                    uiElementsList.add(uiEle);
                }

                Page page = new Page(pageKeyword, uiElementsList);
                pages.add(page);
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebElement getElementByKeyword(String pageKeyword, String uiElementKeyword){
        WebElement webElement = null;
        for (Page page : pages) {
            String keyword = page.getKeyword();
            if(keyword.equalsIgnoreCase(pageKeyword)){
                List<UIElement> uiElementList = page.getUiElementList();
                for (UIElement uiEle : uiElementList) {
                    String uiEleKeyword = uiEle.getKeyword();

                    if(uiEleKeyword.equalsIgnoreCase(uiElementKeyword)){
                        String by = uiEle.getBy();//获取元素选择器 信息
                        String value = uiEle.getValue();// 选择器的值
//                        Base.driver.findElement()
                        webElement = getVisibleElement(by,value);
                    }
                }
            }
        }
        return webElement;
    }

    private static WebElement getVisibleElement(String by, String value){
        WebElement webElement = null;

        WebDriverWait wait = new WebDriverWait(Base.driver, 20);

        By locator = null;

        if("id".equalsIgnoreCase(by)){
            locator = By.id(value);
        } else if("name".equalsIgnoreCase(by)){
            locator = By.name(value);
        }else if("tagName".equalsIgnoreCase(by)){
            locator = By.tagName(value);
        }else if("className".equalsIgnoreCase(by)){
            locator = By.className(value);
        }else if("cssSelector".equalsIgnoreCase(by)){
            locator = By.cssSelector(value);
        }else if("linkText".equalsIgnoreCase(by)){
            locator = By.linkText(value);
        }else if("partialLinkText".equalsIgnoreCase(by)){
            locator = By.partialLinkText(value);
        }else if("xpath".equalsIgnoreCase(by)){
            locator = By.xpath(value);
        }else{
            System.out.println("暂时不支持类型【"+by+"】");
        }


        try{
            webElement = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(Exception e){
            if(e instanceof TimeoutException){
                System.out.println("根据by:【"+by+"】，value 【"+value+"】 定位元素超市");
            }else{
                e.printStackTrace();
            }



        }
        return webElement;
    }
}
