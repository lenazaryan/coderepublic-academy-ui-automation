package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.HomePage;
import com.academy.automation.pageobjects.SignInPage;
import com.academy.automation.pageobjects.StreamPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test()
    public void clickSignInButtonTest() {
        String actualUrl = new HomePage()
                .open()
                .clickSignInButton()
                .getUrl();
        Assert.assertEquals(actualUrl,
                "https://academy-stream.coderepublic.am/login",
                "Incorrect URL Path");

    }

    @Test
    public void redirectBackFromPathsToHomeTest() {
        String result = new HomePage()
                .open()
                .clickPathsButton()
                .clickBack()
                .getUrl();
        Assert.assertEquals(result,
                "https://academy-stream.coderepublic.am/",
                "Incorrect URL"); // Test should fail, bug
    }


}
