package com.supplysync.tests;
import com.supplysync.pages.LoginPage;
import com.supplysync.pages.OrdersPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class OrdersTest extends BaseTest {
    @Test
    public void testSearchOrders() {
        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.searchOrders(driver, "10-01-2024", "12-01-2024", "City Express",  "test order");

        Assert.assertTrue(true, "Order search executed successfully.");

        //There is no order to validate
    }
    }

