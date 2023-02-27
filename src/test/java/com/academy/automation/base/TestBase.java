package com.academy.automation.base;

import org.testng.annotations.*;

import static com.academy.automation.configuration.DriverBase.*;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initDriverObject();
        System.out.println("before method");
    }

    @AfterMethod
    public void closeBrowser() {
        closeDrivers();
        System.out.println("after method");
    }
}
