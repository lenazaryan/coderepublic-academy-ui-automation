package com.academy.automation.pageobjects;
import com.academy.automation.utils.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase<SignInPage> {
    static String PAGE_PATH = "/login";

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

    public HomePage clickBack(){
        Actions.navigateBack();
        return new HomePage();
    }

    public String getUrl(){
        return Actions.getPageUrl();
    }

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

}

