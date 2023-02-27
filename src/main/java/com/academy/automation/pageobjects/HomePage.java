package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase<HomePage> {

    static String PAGE_PATH = "";
    @FindBy(css = ".btn-text-secondary ")
    private WebElement signInBtn;

    @FindBy(xpath = "//a[normalize-space()='HOME']")
    private WebElement homeBtn;

    @FindBy(xpath = "//a[normalize-space()='PATHS']")
    private WebElement pathsBtn;

    public SignInPage clickSignInButton() {
        clickOn(signInBtn);
        return new SignInPage();
    }

    public SignInPage clickPathsButton(){
        clickOn(pathsBtn);
        return new SignInPage();
    }

    public String getUrl(){
        return getPageUrl();
    }

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
        return PAGE_PATH;
    }

    public void clockOnHomeButton() {
        clickOn(homeBtn);
    }
}
