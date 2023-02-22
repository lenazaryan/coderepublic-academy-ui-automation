package com.academy.automation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.academy.automation.configuration.DriverBase.*;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initDriverObject();
        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("before method");
    }

    @AfterMethod
    public void closeBrowser() {
        closeDrivers();
        System.out.println("after method");
        System.out.println();
    }
}
