package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    public  static void selectBy(WebElement location, String attributeValue, String method){
        Select select=new Select(location);
        method=method.toLowerCase();

        switch (method){

            case "text":
                select.selectByVisibleText(attributeValue);
                break;

            case "value":
                select.selectByValue(attributeValue);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(attributeValue));
                break;

            default:
                Assert.fail("The methodName that you provided is not one of the text,value,index "); //It makes your execution fail no matter what
        }
    }

    public static void clickJS(WebDriver driver,WebElement element){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click",element);
    }

    public static void scrollWithJS (WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }

    public  static  void  switchWindow(WebDriver driver, String title){
        Set<String> pageIDs = driver.getWindowHandles();
        for (String pageID : pageIDs) {
            driver.switchTo().window(pageID);
            if (driver.getTitle().contains(title)){
                break;
            }

        }

    }

    public static String getText(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            System.out.println("Failed to get text from element: " + e.getMessage());
            return null;
        }
    }

}

