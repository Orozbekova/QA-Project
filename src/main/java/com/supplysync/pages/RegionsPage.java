package com.supplysync.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegionsPage {
    public RegionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Create Region']")
    WebElement createRegion;

    @FindBy(xpath = "//input[@name='name']")
    WebElement region;


    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[.='Create']")
    WebElement createButton;

    public void createNewRegion(WebDriver driver, String regionName) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.regions.click();
        createRegion.click();
        region.sendKeys(regionName);
        createButton.click();
    }

}

