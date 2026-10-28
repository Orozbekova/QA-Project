package com.supplysync.pages;

import com.utils.BrowserUtils;
import com.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class TariffsPage {
    public TariffsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Create tariff']")
    WebElement createTariff;

    @FindBy(xpath = "//input[@name='branchId']/..")
    WebElement branch;

    @FindBy(xpath = "//input[@name='name']")
    WebElement tariffName;

    @FindBy(xpath = "//input[@name='time']")
    WebElement deliveryTime;

    @FindBy(xpath = "//input[@name='type']/..")
    WebElement deliveryType;

    @FindBy(xpath = "//input[@name='price']")
    WebElement deliveryCost;

    @FindBy(xpath = "//input[@name='regionId']/..")
    WebElement region;

    @FindBy(xpath = "//input[@value='true']")
    WebElement yesButton;

    @FindBy(xpath = "//input[@value='false']")
    WebElement noButton;

    @FindBy(xpath = "//textarea[@name='coordinates']")
    WebElement coordinates;

    @FindBy(xpath = "//textarea[@name='additionalInformation']")
    WebElement additionalInfo;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[.='Create']")
    WebElement createButton;

    public void createNewTariff(WebDriver driver, String deliverType, String name, String time, String price, String regionId, boolean isAvailable, String coords,String addInfo) throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.tariffs.click();
        createTariff.click();
        branch.click();
        driver.findElement(By.xpath("//li[.='Batch 9 - Supply Sync']")).click();
        tariffName.sendKeys(name);
        deliveryTime.sendKeys(time);
        deliveryType.click();
        List<WebElement> dynamicTypes = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement element : dynamicTypes) {
            if (element.getText().equals(deliverType)){
                element.click();
                break;
            }
        }

        deliveryCost.sendKeys(price);
        region.click();
        List<WebElement> dynamicStates = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement state : dynamicStates) {
            if (state.getText().equals(regionId)){
                BrowserUtils.scrollWithJS(driver,state);
                WaitUtils.waitForClick(driver,state,10);
                state.click();
                break;
            }
        }

        if (isAvailable) {
            yesButton.click();
        } else {
            noButton.click();
        }
        coordinates.sendKeys(coords);
        additionalInfo.sendKeys(addInfo);
        createButton.click();
    }


}
