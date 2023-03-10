package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.HomePage;
import com.academy.automation.pageobjects.SignInPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static com.academy.automation.configuration.DriverBase.*;
import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class HomePageTests extends TestBase {

    @Test()
    public void clickSignInButtonTest() {
        String actualUrl = new HomePage()
                .open()
                .clickSignInButton()
                .getUrl();
        assertEquals(actualUrl, "https://academy-stream.coderepublic.am/login",
                "Incorrect URL Path");

    }

    @Test(description = "Verify Back button functionality in Paths section without Login")
    public void testRedirectBackFromPathsToHomeWithoutLogin() {
        String result = new HomePage()
                .open()
                .clickPathsButton()
                .clickBack()
                .getUrl();
        assertEquals(result, "https://academy-stream.coderepublic.am/",
                "Incorrect URL");
        // Test should fail, bug
    }

    @Test(description = "Verify page redirection while network is disconnected")
    public void verifyPageRedirectionWhileNetworkIsDisconnected() {
        SignInPage page = new HomePage()
                .open()
                .clickPathsButton();
        disconnectNetwork();
        String resultPageTitle = page
                .clickBack()
                .reloadHomePage()
                .getTitleOfHomePage();
        connectNetwork();
        assertNotEquals(resultPageTitle, "Picsart Academy Stream", "Fail");
    }

}
