package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.automation.helper.Waiter.getWait;
import static org.testng.Assert.assertNull;

public class ForgotPasswordPage extends PageBase<ForgotPasswordPage> {

    static String PAGE_PATH = "/password_forgot";

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = ".btn-primary.btn-text-primary")
    private WebElement sendBtn;

    @FindBy(css = ".ant-message-custom-content.ant-message-error")
    private WebElement errorMessage;

    @Override
    public ForgotPasswordPage open() {
        return openPage();
    }

    @Override
    public ForgotPasswordPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }

    public ForgotPasswordPage typeEmail(String email) {
        type(emailField, email);
        return this;
    }

    public ForgotPasswordPage clickSendButton() {
        clickOn(sendBtn);
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        getWait().waitUntilElementToBeVisible(errorMessage);
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText(){
        getWait().waitUntilElementToBeVisible(errorMessage);
        return errorMessage.getText();
    }

    public String getValidationMessage(){
        return  emailField.getAttribute("validationMessage");
    }

    public String getUrl() {
        return getPageUrl();
    }
}
