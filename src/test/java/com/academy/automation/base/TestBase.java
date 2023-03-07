package com.academy.automation.base;

import org.testng.annotations.*;

import static com.academy.automation.configuration.DriverBase.*;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initDriverObject();
    }

    @AfterMethod
    public void closeBrowser() {
        closeDrivers();
    }
}
