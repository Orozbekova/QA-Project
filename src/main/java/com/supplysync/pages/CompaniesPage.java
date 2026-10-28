package com.supplysync.pages;

import com.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CompaniesPage {
    public CompaniesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Add elements and actions specific to the companies page
    @FindBy(xpath = "//button[.='Create company']")
    public WebElement createCompany;

    @FindBy(id = "upload-photo")
    WebElement photo;

    @FindBy(xpath = "//input[@name='name']")
    WebElement companyName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='address']")
    WebElement address;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement cellphone;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[.='Create']")
    WebElement createButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public void createNewCompany(WebDriver driver, String img, String name, String emailValue, String addressValue, String cellphoneValue) throws InterruptedException {
        createCompany.click();
        photo.sendKeys(img);
        companyName.sendKeys(name);
        email.sendKeys(emailValue);
        address.sendKeys(addressValue);
        WaitUtils.waitForClick(driver,cellphone,10);
        cellphone.click();
        cellphone.sendKeys(cellphoneValue);
//        Thread.sleep(3000);
        createButton.click();
    }

    public void editCompany(WebDriver driver, String oldName, String newName) throws InterruptedException {
        List<WebElement> editButtons1 =driver.findElements(By.xpath("//img[@alt='MenuIcon']"));
        List<WebElement> editButtons2 =driver.findElements(By.xpath("//li[.='Edit']"));
        List<WebElement> companies = driver.findElements(By.cssSelector(".sc-jCHUfY.hSzgVJ"));
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getText().equals(oldName)){
                editButtons1.get(i).click();
                editButtons2.get(i).click();
                break;
        }}
            WaitUtils.waitForClick(driver, companyName, 10);
            companyName.clear();
            companyName.sendKeys(newName);
            submitButton.click();
    }

    public boolean isCompanyDuplicated(WebDriver driver, String companyName) {
        try {
            WebElement error = driver.findElement(By.xpath("//*[contains(text(),'already exists') or contains(text(),'Duplicate')]"));
            return error.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
