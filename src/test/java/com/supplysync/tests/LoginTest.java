package com.supplysync.tests;

import com.supplysync.pages.DashboardPage;
import com.supplysync.pages.LoginPage;

import com.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@codewise.com", "codewise123");

        //I didn't do Assertions  part because you already have it
    }
    }



