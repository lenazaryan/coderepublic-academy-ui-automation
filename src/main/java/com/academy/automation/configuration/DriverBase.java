package com.academy.automation.configuration;

import org.openqa.selenium.WebDriver;

public class DriverBase {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return driverPool.get();
    }

    public static void initDriverObject() {
        driverPool.set(DriverConfig.createWebDriver("chrome"));
    }

    public static void closeDrivers() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        else
           driverPool.remove();
        }

    }
