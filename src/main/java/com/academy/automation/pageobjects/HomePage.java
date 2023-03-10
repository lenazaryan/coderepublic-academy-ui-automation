package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.automation.configuration.DriverBase.getDriver;

public class HomePage extends PageBase<HomePage> {
    @FindBy(css = ".btn-text-secondary ")
    private WebElement signInBtn;

    @FindBy(css = ".nav-item:nth-child(1)")
    private WebElement homeBtn;

    @FindBy(css = ".nav-item:nth-child(2)")
    private WebElement pathsBtn;

    @Override
    public HomePage open() {
        return openPage();
    }

    @Override
    public HomePage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return null;
    }

    public HomePage clockOnHomeButton() {
        clickOn(homeBtn);
        return this;
    }

    public SignInPage clickSignInButton() {
        clickOn(signInBtn);
        return new SignInPage();
    }

    public SignInPage clickPathsButton() {
        clickOn(pathsBtn);
        return new SignInPage();
    }

    public HomePage reloadHomePage(){
        reloadPage();
        return this;
    }

    public String getTitleOfHomePage(){
        return getDriver().getTitle();
    }

    public String getUrl() {
        return getPageUrl();
    }

}
