package com.supplysync.tests;

import com.supplysync.pages.LoginPage;
import com.supplysync.pages.TariffsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

//import static com.utils.DriverManager.driver;

public class TariffsTest extends BaseTest{
    @Test
    public void testCreateTariff() throws InterruptedException {
        TariffsPage tariffsPage = new TariffsPage(driver);
        tariffsPage.createNewTariff(driver, "City express", "Express Delivery", "24", "2500", "Illinois",  true, "[40.7128,-74.0060]", "Use gate code 1234");

        String expectedValue = "Tariff created successfully";
        WebElement msg = driver.findElement(By.xpath("//*[.='Tariff created successfully']"));
        String actualValue = msg.getText();
        Assert.assertTrue(expectedValue.equals(actualValue));

    }
}
