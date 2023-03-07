package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.LoggedInHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchResultPageTests extends TestBase {
    @Test(description = "Check Back functionality from Search Results Page")
    public void testBackFunctionalityFromSearchResultsPage() {
        new LoggedInHomePageTests()
                .verifyLoginWithValidCredentials();
        String resultUrl = new LoggedInHomePage()
                .open()
                .typeInSearchField("test")
                .clickSearchSubmitButton()
                .clickBack()
                .getUrl();
        assertEquals(resultUrl, "https://academy-stream.coderepublic.am/search", "Incorrect URL");
    }
}
