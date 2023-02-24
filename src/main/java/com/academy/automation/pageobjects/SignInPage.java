package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SignInPage extends PageBase {

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;


    public StreamPage login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        clickOn(submitBtn);
        return new StreamPage();
    }


}

