package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.LoggedInHomePage;
import com.academy.automation.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoggedInHomePageTests extends TestBase {

    @BeforeMethod(description = "Verify Sign in with Valid credentials")
    public void verifyLoginWithValidCredentials() {
        String resultURL = new SignInPage()
                .open()
                .typeEmail("vardan.l.grigoryan@gmail.com")
                .typePassword("academy2023")
                .clickSubmitButton()
                .init()
                .getUrl();
        assertEquals(resultURL,
                "https://academy-stream.coderepublic.am/",
                "Incorrect URL");
    }

    @Test(description = "Verify Back button functionality in Paths section when Logged-in")
    public void testRedirectBackFromPathsToHomeWhenLoggedIn() {
        String result = new LoggedInHomePage()
                .open()
                .clickPathsButton()
                .clickBack()
                .getUrl();
        assertEquals(result,
                "https://academy-stream.coderepublic.am/",
                "Incorrect URL");
    }

    @Test(description = "Check if input in the search field is displayed correctly")
    public void checkIfSearchValueIsCorrect() {
        String searchValue = new LoggedInHomePage()
                .open()
                .hoverSearchField()
                .clickOnSearchField()
                .typeInSearchField("test")
                .getValueOfSearchField();
        assertEquals(searchValue, "test");
    }

    @Test(description = "Verify that user is redirected to Search Result Page after clicking Submit button on the search field")
    public void testRedirectToSearchResultPageWithClickingSubmitButton() {
        String resultUrl = new LoggedInHomePage()
                .open()
                .typeInSearchField("test")
                .clickSearchSubmitButton()
                .getUrl();
        assertEquals(resultUrl,
                "https://academy-stream.coderepublic.am/search?q=test",
                "Incorrect URL");
    }

    @Test(description = "Verify that Search Submit Button works with Enter key")
    public void testRedirectToSearchResultPageWithEnterKey() {
        String resultUrl = new LoggedInHomePage()
                .open()
                .typeInSearchField("test")
                .pressEnterKeyOnSearchSubmitButton()
                .getUrl();
        assertEquals(resultUrl,
                "https://academy-stream.coderepublic.am/search?q=test",
                "Incorrect URL");
    }

    @Test(description = "Verify that Search Submit Button is disabled if search field is Empty")
    public void testSubmitButtonWithEmptySearchField() {
        boolean submitBtnIsDisabled = new LoggedInHomePage()
                .open()
                .isSearchButtonDisabled();
        Assert.assertTrue(submitBtnIsDisabled, "Search Submit Button should not be Enabled, but it is");
    }


}
