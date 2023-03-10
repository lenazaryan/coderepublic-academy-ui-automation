package com.academy.automation.configuration;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

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
        } else
            driverPool.remove();
    }

    public static void disconnectNetwork() {
        try {
            ProcessBuilder builder = new ProcessBuilder("networksetup", "-setairportpower", "airport", "off");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void connectNetwork() {
        try {
            ProcessBuilder builder = new ProcessBuilder("networksetup", "-setairportpower", "airport", "on");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
