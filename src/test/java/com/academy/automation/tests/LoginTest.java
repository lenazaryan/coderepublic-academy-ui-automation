package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.SignInPage;
import com.academy.automation.pageobjects.StreamPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "", dataProvider = "login-set", dataProviderClass = PageData.class)
    public void loginInvalidCredentialsTest(String email, String pass) throws InterruptedException {
        new SignInPage()
                .open()
                .typeEmail(email)
                .typePassword(pass)
                .clickSubmitButton()
                .init();
        Thread.sleep(3000L);
        boolean userIconIsDisplayed = new StreamPage().userIconIsDisplayed();
        Assert.assertFalse(userIconIsDisplayed, "User Icon Should Not Be Displayed But It Is");
    }

}
