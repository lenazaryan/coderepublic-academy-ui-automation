package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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


}
