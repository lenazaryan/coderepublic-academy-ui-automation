package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.SignInPage;
import com.academy.automation.pageobjects.StreamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StreamPageTests extends TestBase {

    @BeforeMethod()
    public void loginSuccessfulTest(){
        String resultURL = new SignInPage()
                .open()
                .typeEmail("vardan.l.grigoryan@gmail.com")
                .typePassword("academy2023")
                .clickSubmitButton()
                .init()
                .getUrl();
        Assert.assertEquals(resultURL,
                "https://academy-stream.coderepublic.am/",
                "Incorrect URL");
    }

    @Test()
    public void headerSearchValueTest() {
        String searchValue = new StreamPage()
                .open()
                .hoverHeaderSearchField()
                .clickHeaderSearchField()
                .typeInSearchField("test")
                .getValueOfSearchField();
        Assert.assertEquals(searchValue, "test");
    }

    @Test()
    public void searchNoResultsTest() {
        String resultUrl = new StreamPage()
                .open()
                .typeInSearchField("test")
                .clickHeaderSearchSubmitButton()
                .getUrl();
        Assert.assertEquals(resultUrl,
                "https://academy-stream.coderepublic.am/search?q=test",
                "");
    }
}
