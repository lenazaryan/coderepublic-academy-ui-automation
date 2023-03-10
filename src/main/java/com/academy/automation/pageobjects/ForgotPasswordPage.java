package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.automation.helper.Waits.getWait;
import static org.testng.Assert.assertNull;

public class ForgotPasswordPage extends PageBase<ForgotPasswordPage> {

    static String PAGE_PATH = "/password_forgot";

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = ".btn-primary.btn-text-primary")
    private WebElement sendBtn;

    @FindBy(css = ".ant-message-notice-content .ant-message-custom-content")
    //.ant-message-custom-content ant-message-success\.ant-message-custom-content.ant-message-error
    private WebElement antMessage;

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
        getWait().waitUntilElementToBeVisible(antMessage);
        return antMessage.isDisplayed();
    }

    public String getErrorOrSuccessMessageText() {
        getWait().waitUntilElementToBeVisible(antMessage);
        return antMessage.getText();
    }

    public String getValidationMessage() {
        return emailField.getAttribute("validationMessage");
    }

    public String getUrl() {
        return getPageUrl();
    }
}
