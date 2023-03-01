package com.academy.automation.utils;

import org.openqa.selenium.WebElement;

import static com.academy.automation.configuration.DriverBase.getDriver;

public class Actions {
    public static void hover(WebElement element){
        new org.openqa.selenium.interactions.Actions(getDriver()).moveToElement(element).perform();
    }

    public static void navigateBack(){
        getDriver().navigate().back();
    }

    public static String getPageUrl(){
        return getDriver().getCurrentUrl();
    }
}
