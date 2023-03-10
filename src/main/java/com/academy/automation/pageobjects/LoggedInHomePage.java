package com.academy.automation.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.automation.helper.Waits.getWait;

public class LoggedInHomePage extends PageBase<LoggedInHomePage> {

    @FindBy(css = ".user_icon")
    private WebElement userIcon;

    @FindBy(css = ".nav-item:nth-child(1)")
    private WebElement homeBtn;

    @FindBy(css = ".nav-item:nth-child(2)")
    private WebElement pathsBtn;

    @FindBy(css = ".notification_icon")
    private WebElement notificationIcon;
    @FindBy(css = ".header-search")
    private WebElement searchField;
    @FindBy(css = "button[type='submit']")
    private WebElement searchSubmitBtn;

    @Override
    public LoggedInHomePage open() {
        return openPage();
    }

    @Override
    public LoggedInHomePage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return null;
    }

    public boolean userIconIsDisplayed() {
        return isElementDisplayed(userIcon);
    }

    public String getUrl() {
        return getPageUrl();
    }

    public SignInPage clickPathsButton() {
        clickOn(pathsBtn);
        return new SignInPage();
    }

    public LoggedInHomePage hoverSearchField() {
        hover(searchField);
        return this;
    }

    public LoggedInHomePage clickOnSearchField() {
        clickOn(searchField);
        return this;
    }

    public LoggedInHomePage typeInSearchField(String text) {
        type(searchField, text);
        return this;
    }

    public SearchResultPage clickSearchSubmitButton() {
        clickOn(searchSubmitBtn);
        return new SearchResultPage();
    }

    public SearchResultPage pressEnterKeyOnSearchSubmitButton() {
        searchSubmitBtn.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }

    public String getValueOfSearchField() {
        return searchField.getAttribute("value");
    }

    public boolean isSearchButtonDisabled() {
        getWait().waitUntilElementToBeVisible(searchSubmitBtn);
        return searchSubmitBtn.isDisplayed();
    }
}
