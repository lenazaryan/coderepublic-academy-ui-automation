package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.configuration.DriverBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.HomePage;
import com.academy.automation.pageobjects.SignInPage;
import com.academy.automation.pageobjects.StreamPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTest extends TestBase {

    @Test
    public void clickSignInButtonTest() {
        new HomePage().clickSignInButton();
        String actualUrl = DriverBase.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://academy-stream.coderepublic.am/login", "Incorrect URL");

    }

    @Test(dataProvider = "login-set", dataProviderClass = PageData.class)
    public void loginTest(String email, String pass) throws InterruptedException {
        clickSignInButtonTest();
        new SignInPage().login(email, pass);
        Thread.sleep(3000L);
        boolean isDisplayed = new StreamPage().userIconIsDisplayed();
        Assert.assertTrue(isDisplayed, "Fail");
    }



}
