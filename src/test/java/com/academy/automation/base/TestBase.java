package com.academy.automation.base;

import org.testng.annotations.*;

import static com.academy.automation.configuration.DriverBase.*;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initDriverObject();
        getDriver().get("https://academy-stream.coderepublic.am/");
        System.out.println("before method");
    }

    @AfterMethod
    public void closeBrowser() {
        closeDrivers();
        System.out.println("after method");
    }
}
