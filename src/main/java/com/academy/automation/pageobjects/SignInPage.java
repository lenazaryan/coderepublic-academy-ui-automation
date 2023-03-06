package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase<SignInPage> {
    static String PAGE_PATH = "/login";

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = ".btn-primary")
    private WebElement submitBtn;

    @Override
    public SignInPage open() {
        return openPage();
    }

    @Override
    public SignInPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }

    public SignInPage typeEmail(String email) {
        type(emailField, email);
        return this;
    }

    public SignInPage typePassword(String password){
        type(passwordField, password);
        return this;
    }

    public StreamPage clickSubmitButton() {
        clickOn(submitBtn);
        return new StreamPage();
    }

    public HomePage clickBack() {
        navigateBack();
        return new HomePage();
    }

    public String getUrl() {
        return getPageUrl();
    }


}

