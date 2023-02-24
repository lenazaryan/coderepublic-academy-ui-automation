package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    @FindBy(css = ".btn-text-secondary ")
    WebElement signInBtn;

    public SignInPage clickSignInButton(){
        clickOn(signInBtn);
        return new SignInPage();
    }
}
