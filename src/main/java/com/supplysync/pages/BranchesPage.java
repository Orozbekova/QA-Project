package com.supplysync.pages;

import com.utils.BrowserUtils;
import com.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class BranchesPage {
    public BranchesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Create Branch']")
    WebElement createBrunch;

    @FindBy(xpath = "//input[@name='name']")
    WebElement branchName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='address']")
    WebElement address;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement cellphone;

    @FindBy(xpath = "//input[@name='city']")
    WebElement location;

    @FindBy(xpath = "//input[@name='regionId']/..")
    WebElement region;

    @FindBy(xpath = "//input[@name='companyId']/..")
    WebElement company;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[.='Create']")
    WebElement createButton;


    public void createNewBranch(WebDriver driver, String name, String emailValue, String addressValue, String cell, String loc, String reg, String comp) throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.branches.click();

        createBrunch.click();
        branchName.sendKeys(name);
        email.sendKeys(emailValue);
        address.sendKeys(addressValue);
        cellphone.click();
        cellphone.sendKeys(cell);
        location.sendKeys(loc);
        region.click();
        List<WebElement> dynamicStates = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement state : dynamicStates) {
            if (state.getText().equals(reg)) {
                BrowserUtils.scrollWithJS(driver, state);
                WaitUtils.waitForClick(driver, state, 10);
                state.click();
                break;
            }
        }
        company.click();
        List<WebElement> companies = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement element : companies) {
            if (element.getText().equals(comp)) {
                BrowserUtils.scrollWithJS(driver, element);
                WaitUtils.waitForClick(driver, element, 10);
                element.click();
                break;
            }
        }
        createButton.click();
    }

    public void deleteBranch(WebDriver driver, String branchName) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.branches.click();
        List<WebElement> branches = driver.findElements(By.cssSelector(".sc-bnOPBZ.jOCskN > h3"));
        List<WebElement> menuIcons = driver.findElements(By.xpath("//img[@alt='MenuIcon']"));
        List<WebElement> deleteOptions = driver.findElements(By.xpath("//li[.='Delete']"));
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getText().equals(branchName)) {
                menuIcons.get(i).click();
                deleteOptions.get(i).click();
                WebElement confirmDelete = driver.findElement(By.xpath("//button[.='Delete']"));
                confirmDelete.click();
                break;
            }
        }
    }
}