package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.SignInPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import static com.academy.automation.configuration.DriverBase.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class SignInPageTests extends TestBase {

    @Test(description = "Verify Sign in with Invalid credentials", dataProvider = "login-set", dataProviderClass = PageData.class)
    public void testLoginWithInvalidCredentials(String email, String pass) throws InterruptedException {
        boolean userIconIsDisplayed = new SignInPage()
                .open()
                .typeEmail(email)
                .typePassword(pass)
                .clickSubmitButton()
                .init()
                .userIconIsDisplayed();
        assertFalse(userIconIsDisplayed, "User Icon Should Not Be Displayed But It Is");
    }

    @Test(description = "Verify password masking")
    public void verifyPasswordMasking() {
        new SignInPage()
                .open()
                .typePassword("test123");
        String screenshotOfFirstPassword = ((TakesScreenshot) getDriver())
                .getScreenshotAs(OutputType.BASE64);

        new SignInPage()
                .open()
                .typePassword("TEST345");
        String screenshotOfSecondPassword = ((TakesScreenshot) getDriver())
                .getScreenshotAs(OutputType.BASE64);
        assertEquals(screenshotOfFirstPassword, screenshotOfSecondPassword, "Screenshots are Different");
    }
}
