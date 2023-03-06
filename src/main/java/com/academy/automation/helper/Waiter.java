package com.academy.automation.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.academy.automation.configuration.DriverBase.*;
import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Waiter {
    private static int SHORT_WAIT = 2;
    private static int WAIT = 3;
    private static int LONG_WAIT = 6;
    private static WebDriverWait wait;

    private Waiter() {
    }

    public static Waiter getShortWait() {
        return getCustomWait(SHORT_WAIT);
    }

    public static Waiter getWait() {
        return getCustomWait(WAIT);
    }

    public static Waiter getLongWait() {
        return getCustomWait(LONG_WAIT);
    }

    private static Waiter getCustomWait(int timeout) {
        Waiter waitHandler = new Waiter();
        wait = new WebDriverWait(getDriver(), ofSeconds(timeout), ofMillis(50));
        return waitHandler;
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }

    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException exception) {
            //exception_handler
        }
    }


}

