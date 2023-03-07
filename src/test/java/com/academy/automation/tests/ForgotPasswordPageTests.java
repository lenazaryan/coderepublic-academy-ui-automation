package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.pageobjects.SignInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordPageTests extends TestBase {
    @Test(description = "Verify text of Error message with Invalid email ")
    public void testForgotPasswordLink() {
        String messageText = new SignInPage()
                .open()
                .clickForgotPasswordLink()
                .init()
                .typeEmail("test@test.com")
                .clickSendButton()
                .getErrorMessageText();
        assertEquals(messageText, "Something went wrong", "Incorrect Error message");
    }

    @Test(description = "Verify text of Error message without email")
    public void verifyErrorMessageText() {
        String messageText = new SignInPage()
                .open()
                .clickForgotPasswordLink()
                .init()
                .clickSendButton()
                .getErrorMessageText();
        assertEquals(messageText, "Something went wrong", "Incorrect Error message");
    }

    @Test(description = "Verify validation message for incorrect format email")
    public void testIncorrectFormatEmailValidation(){
        String validationMessage = new SignInPage()
                .open()
                .clickForgotPasswordLink()
                .init()
                .typeEmail("test")
                .getValidationMessage();
        assertEquals(validationMessage,
                "Please include an '@' in the email address. 'test' is missing an '@'.",
                "Incorrect validation message");
    }
}
