package com.supplysync.tests;

import com.supplysync.pages.BranchesPage;
import com.supplysync.pages.LoginPage;
import com.supplysync.pages.MastersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MastersTest extends BaseTest{
    @Test
    public void testCreateMaster() {
        MastersPage mastersPage = new MastersPage(driver);
        mastersPage.createNewMaster(driver,"John", "Doe", "john.doe@example.com", "password123", "New York", "1234567890");

        String expectedValue = "Master added successfully";
        WebElement msg = driver.findElement(By.xpath("//*[.='Master added successfully']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }

    @Test
    public void testDeleteMaster() {
        MastersPage mastersPage = new MastersPage(driver);
        String masterName = "John Doe";
        mastersPage.deleteMaster(driver, masterName);
        String expectedValue = "Master removed successfully";
        WebElement msg = driver.findElement(By.xpath("//*[.='Master removed successfully']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }
    }
