package com.supplysync.tests;
import com.supplysync.pages.BranchesPage;
import com.supplysync.pages.MastersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class BranchesTest extends BaseTest{
    @Test
    public void testCreateBranch() throws InterruptedException {
        BranchesPage branchesPage = new BranchesPage(driver);
        branchesPage.createNewBranch(driver, "Branch A", "branch@example.com", "456 Branch Road", "5551234567", "Springfield", "Illinois", "CodeWise LLC");
        String expectedValue = "Branch successfully created";
        WebElement msg = driver.findElement(By.xpath("//*[.='Branch successfully created']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }


    @Test
    public void testDeleteBranch() {
        BranchesPage branchPage = new BranchesPage(driver);
        String branchName = "Branch A";
        branchPage.deleteBranch(driver, branchName);
        String expectedValue = "Branch deleted successfully";
        WebElement msg = driver.findElement(By.xpath("//*[.='Branch deleted successfully']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }
    }

