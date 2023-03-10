package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.SignInPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.academy.automation.configuration.DriverBase.getDriver;
import static org.testng.Assert.assertEquals;

public class SignInPageTests extends TestBase {

    @Test(description = "Verify invalid Email and Password Error messages and disabled state of Submit button",
            dataProvider = "invalid-email-password-data", dataProviderClass = PageData.class)
    public void testLoginWithInvalidCredentials(String email, String pass,
                                                String expectedEmailError,
                                                String expectedPasswordError
    ) {
        SignInPage page = new SignInPage().open();
        SoftAssert softAssert = new SoftAssert();

        page.clickSubmitButton();
        String actualEmailError = page
                .typeEmail(email)
                .init()
                .getTextOfEmailErrorMessage();
        softAssert.assertEquals(actualEmailError, expectedEmailError,
                "Failed on Email validation error");

        String actualPasswordError = page
                .typePassword(pass)
                .init()
                .getTextOfPasswordErrorMessage();
        softAssert.assertEquals(actualPasswordError, expectedPasswordError,
                "Failed on Password validation error");

        softAssert.assertFalse(page.isSubmitButtonEnabled(),
                "Submit button should disabled, but it is not");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with incorrect email and password",
            dataProvider = "incorrect-email-password-set", dataProviderClass = PageData.class)
    public void testLoginWithIncorrectEmailAndPassword(String email, String password) {
        String errorMessageText = new SignInPage()
                .open()
                .typeEmail(email)
                .typePassword(password)
                .clickSignInButton()
                .getErrorTextForIncorrectEmailOrPassword();
        assertEquals(errorMessageText, "Incorrect email or password", "Incorrect error message");
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
