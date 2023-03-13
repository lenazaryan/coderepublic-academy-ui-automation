package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.automation.helper.Waits.getWait;

public class SignInPage extends PageBase<SignInPage> {
    static String PAGE_PATH = "/login";
    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = ".btn-primary")
    private WebElement submitBtn;
    @FindBy(css = ".forgot")
    private WebElement forgotPassword;
    @FindBy(css = "#email + p.err_message")
    private WebElement emailErrorMessage;
    @FindBy(css = "#password + p.err_message")
    private WebElement passwordErrorMessage;
    @FindBy(css = ".err_mess")
    private WebElement incorrectEmailOrPasswordMessage;
    @FindBy(css = ".user_info-image")
    private WebElement userInfoImage;
    @FindBy(css = ".user_info-text")
    private WebElement userInfoName;
    @FindBy(css = ".user_profil .text-tertiary.text-tertiary--gray:nth-child(1)")
    private WebElement userInfoHistory;
    @FindBy(css = ".user_profil .text-tertiary.text-tertiary--gray:nth-child(2)")
    private WebElement userInfoLikedVideos;
    @FindBy(css = ".log_out .text-tertiary .text-tertiary--gray")
    private WebElement userInfoLogOut;

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

    public SignInPage typePassword(String password) {
        type(passwordField, password);
        return this;
    }

    public LoggedInHomePage clickSubmitButton() {
        clickOn(submitBtn);
        return new LoggedInHomePage();
    }

    public SignInPage clickSignInButton() {
        clickOn(submitBtn);
        return this;
    }

    public boolean isSubmitButtonEnabled() {
        return submitBtn.isEnabled();
    }

    public boolean isIncorrectEmailOrPassErrorDisplayed() {
        return isElementDisplayed(incorrectEmailOrPasswordMessage);
    }

    public String getTextOfEmailErrorMessage() {
        getWait().waitUntilElementToBeVisible(emailErrorMessage);
        return emailErrorMessage.getText();
    }

    public String getTextOfPasswordErrorMessage() {
        getWait().waitUntilElementToBeVisible(passwordErrorMessage);
        return passwordErrorMessage.getText();
    }

    public String getErrorTextForIncorrectEmailOrPassword() {
        getWait().waitUntilElementToBeVisible(incorrectEmailOrPasswordMessage);
        return incorrectEmailOrPasswordMessage.getText();
    }

    public boolean isUserInfoImageDisplayed() {
        return isElementDisplayed(userInfoImage);
    }

    public boolean isUserInfoNameDisplayed() {
        return isElementDisplayed(userInfoName);
    }

    public boolean isUserInfoHistoryDisplayed() {
        return isElementDisplayed(userInfoHistory);
    }

    public boolean isUserInfoLikedVideosDisplayed() {
        return isElementDisplayed(userInfoLikedVideos);
    }

    public boolean isUserInfoLogOutDisplayed() {
        return isElementDisplayed(userInfoLogOut);
    }

    public HomePage clickBack() {
        navigateBack();
        return new HomePage();
    }

    public ForgotPasswordPage clickForgotPasswordLink() {
        clickOn(forgotPassword);
        return new ForgotPasswordPage();
    }

    public String getUrl() {
        return getPageUrl();
    }


}

