package com.supplysync.tests;
import com.supplysync.pages.RegionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegionsTest extends BaseTest {
    @Test
    public void testCreateRegion() {
        RegionsPage regionsPage = new RegionsPage(driver);
        regionsPage.createNewRegion(driver,"Arizona");

        String expectedValue = "Region created successfully";
        WebElement msg = driver.findElement(By.xpath("//*[.='Region created successfully']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));
    }
}
//The frontend doesn't send the expected regionName parameter in the create region request. As a result, the backend rejects the request and the region cannot be created, even though the user enters a valid region name.
//Expected:
//Region should be created successfully.
//Actual:
//Error message appears, and the region is not created.

