package com.supplysync.tests;

import com.supplysync.pages.LoginPage;
import com.utils.ConfigReader;
import com.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://supplysync.us");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@codewise.com", "codewise123");
    }

//     @AfterMethod
//    public void tearDown(){
//       driver.quit();
//    }

}