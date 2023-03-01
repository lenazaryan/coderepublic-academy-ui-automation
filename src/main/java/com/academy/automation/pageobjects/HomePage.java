package com.academy.automation.pageobjects;

import com.academy.automation.utils.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase<HomePage> {
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
        return Actions.getPageUrl();
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
        return null;
    }

    public HomePage clockOnHomeButton() {
        clickOn(homeBtn);
        return this;
    }
}
