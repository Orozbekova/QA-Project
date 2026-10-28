package com.supplysync.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Companies']")
    public  WebElement companies;

    @FindBy(xpath = "//span[.='Branches']")
    public  WebElement branches;

    @FindBy(xpath = "//span[.='Masters']")
    public  WebElement masters;

    @FindBy(xpath = "//span[.='Tariffs']")
    public  WebElement tariffs;

    @FindBy(xpath = "//span[.='Orders']")
    public  WebElement orders;

    @FindBy(xpath = "//span[.='Regions']")
    public  WebElement regions;

    @FindBy(xpath = "//button[.='Administrator']")
    public  WebElement administrator;

    @FindBy(xpath = "//li[.='Exit']")
    public  WebElement logOut;

}
