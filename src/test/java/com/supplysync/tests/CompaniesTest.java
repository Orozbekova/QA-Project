package com.supplysync.tests;

import com.supplysync.pages.BranchesPage;
import com.supplysync.pages.CompaniesPage;
import com.supplysync.pages.LoginPage;
import com.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.utils.DriverManager.driver;
import static com.utils.DriverManager.getDriver;

public class CompaniesTest extends BaseTest{
    @Test
    public void testAddCompany() throws InterruptedException {
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.createNewCompany(
                driver,
                "/Users/umutai/Downloads/codewise.jpeg",
                "CodeWise LLC",
                "contact@codewise.com",
                "123 Tech Blvd",
                "1234567890"
        );

        String expectedValue = "Company successfully established";
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(), 'Company successfully established')]"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }

    @Test
    public void testEditCompany() throws InterruptedException {
        CompaniesPage companiesPage = new CompaniesPage(driver);
        companiesPage.editCompany(driver,"new name","name");
        String expectedValue = "Company successfully changed";
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(), 'Company successfully changed')]"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }
    @Test
    public void testIsCompanyDuplicated() throws InterruptedException {
        List<WebElement> companyNames = driver.findElements(By.cssSelector(".sc-hGnimi.dzgArk"));
        HashSet<String> uniqueCompanyNames= new HashSet<>();
        for (WebElement companyName : companyNames) {
            uniqueCompanyNames.add(companyName.getText());
    }
    System.out.println(uniqueCompanyNames);
    int actualCompanyCount = companyNames.size();
        int expectedCompanyCount = uniqueCompanyNames.size();

        Assert.assertEquals(actualCompanyCount,expectedCompanyCount, "There are " + (actualCompanyCount - expectedCompanyCount) + " duplicated companies");
    }}
