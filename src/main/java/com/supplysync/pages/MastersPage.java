package com.supplysync.pages;

import com.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MastersPage {
    public MastersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Add elements and actions specific to the masters page

    @FindBy(xpath = "//button[.='Create Master']")
    WebElement createMaster;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='location']")
    WebElement residencePlace;

    @FindBy(xpath = "//input[@name='number']")
    WebElement cellphone;

    @FindBy(xpath = "//input[@name='branch_id']/..")
    WebElement branch;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[.='Create']")
    WebElement createButton;

    public void createNewMaster(WebDriver driver, String firstName, String last, String emailValue, String pass, String location, String cell) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.masters.click();
        createMaster.click();
        name.sendKeys(firstName);
        lastName.sendKeys(last);
        email.sendKeys(emailValue);
        password.sendKeys(pass);
        residencePlace.sendKeys(location);
        cellphone.click();
        cellphone.sendKeys(cell);
        WaitUtils.waitForClick(driver,branch,10);
        branch.click();
        driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();
        createButton.click();
    }

    public  void deleteMaster(WebDriver driver, String masterName){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.masters.click();
        List<WebElement> masterNames = driver.findElements(By.cssSelector("div.sc-bnOPBZ.fCaCyp > h3"));
        List<WebElement> menuIcons = driver.findElements(By.xpath("//img[@alt='MenuIcon']"));
        List<WebElement> deleteOptions = driver.findElements(By.xpath("//li[.='Delete']"));
        for (int i = 0; i < masterNames.size(); i++) {
            if(masterNames.get(i).getText().equals(masterName)){
                menuIcons.get(i).click();
                deleteOptions.get(i).click();
                WebElement confirmDelete = driver.findElement(By.xpath("//button[.='Delete']"));
                confirmDelete.click();
                break;
            }
        }
    }

}
