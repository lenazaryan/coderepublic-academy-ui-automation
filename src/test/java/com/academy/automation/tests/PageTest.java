package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.HomePage;
import com.academy.automation.pageobjects.SignInPage;
import com.academy.automation.pageobjects.StreamPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageTest extends TestBase {

    @Test
    public void clickSignInButtonTest() {
        String actualUrl = new HomePage()
                .open()
                .clickSignInButton()
                .getUrl();
        Assert.assertEquals(actualUrl, "https://academy-stream.coderepublic.am/login", "Incorrect URL Path");

    }

    @Test(dataProvider = "login-set", dataProviderClass = PageData.class)
    public void loginInvalidCredentialsTest(String email, String pass) throws InterruptedException {
        clickSignInButtonTest();
        new SignInPage()
                .open()
                .login(email, pass);
        Thread.sleep(3000L);
        boolean userIconIsDisplayed = new StreamPage().userIconIsDisplayed();
        Assert.assertFalse(userIconIsDisplayed, "User Icon Should Not Be Displayed But It Is");
    }

    @Test
    public void loginSuccessfulTest() throws InterruptedException {
        StreamPage streamPage = new SignInPage()
                .open()
                .login("vardan.l.grigoryan@gmail.com", "academy2023");
        Thread.sleep(3000L);
        String resultUrl = streamPage.getUrl();
        Assert.assertTrue(resultUrl.contains("https://academy-stream.coderepublic.am"), "Incorrect URL");
    }

    @Test
    public void redirectBackFromPathsToHomeTest() throws InterruptedException {
        String result = new HomePage()
                .open()
                .clickPathsButton()
                .clickBack()
                .getUrl();
        Thread.sleep(3000L);
        Assert.assertEquals(result, "https://academy-stream.coderepublic.am/", "Incorrect URL"); // Test should fail. Bug: doesn't redirect back to HomePage
    }

    @Test
    public void headerSearchIsClickedTest()throws InterruptedException{
        loginSuccessfulTest();
        boolean isClicked = new StreamPage().init().headerSearchFieldIsClicked();
        Thread.sleep(3000L);
        String value = new StreamPage().init().getCssValueOfSearchField("color");
        String value2 = new StreamPage().init().getCssValueOfSearchField("background-color");
//        System.out.println("color: " + value + "\nbackground-color: " + value2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isClicked, "SearchField is Not Clicked");
        softAssert.assertEquals(value, "rgba(0, 0, 0, 0.85)", "Incorrect search field color");
        softAssert.assertEquals(value2, "rgba(255, 255, 255, 1)", "Incorrect search field Background-color");
        softAssert.assertAll();
    }

    @Test
    public void headerSearchIsHoveredColorTest()throws InterruptedException{
        loginSuccessfulTest();
        Thread.sleep(3000L);
        Assert.assertEquals(new StreamPage()
                .init().hoverHeaderSearchField()
                .getCssValueOfSearchField("color"),
                "rgba(0, 0, 0, 0.85)", "Wrong color");
    }

}
