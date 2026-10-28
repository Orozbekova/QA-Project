package com.supplysync.pages;

import com.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class OrdersPage {
    public OrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#mui-2")
    WebElement dateFrom;

    @FindBy(css = "#mui-3")
    WebElement dateTo;

    @FindBy(css = "#mui-component-select-deliveryType")
    WebElement deliveryType;

    @FindBy(css = "#mui-component-select-branchId")
    WebElement city;


    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInput;


    public void searchOrders(WebDriver driver, String from, String to, String type, String keyword) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        WaitUtils.waitForClick(driver, dashboardPage.orders, 10);
        dashboardPage.orders.click();
        dateFrom.sendKeys(from);
        dateTo.sendKeys(to);

        deliveryType.click();
        List<WebElement> dynamicTypes = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement element: dynamicTypes) {
            if (element.getText().equals(type)){
                element.click();
                break;
            }
        }

        city.click();
        driver.findElement(By.xpath("//li[.='Batch 9 - Supply Sync']")).click();
        searchInput.sendKeys(keyword);
    }

}

