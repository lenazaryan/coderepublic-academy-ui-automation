package com.academy.automation.tests;

import com.academy.automation.base.TestBase;
import com.academy.automation.dataprovider.PageData;
import com.academy.automation.pageobjects.SignInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordPageTests extends TestBase {

    @Test(description = "Verify message text with incorrect and correct email ",
            dataProvider = "correct-incorrect-email-set-for-forgot-password", dataProviderClass = PageData.class)
    public void testForgotPasswordLink(String email, String expectedMessageText) {
        String actualMessageText = new SignInPage()
                .open()
                .clickForgotPasswordLink()
                .init()
                .typeEmail(email)
                .clickSendButton()
                .getErrorOrSuccessMessageText();
        assertEquals(actualMessageText, expectedMessageText, "Incorrect Error/Success message");
    }

    @Test(description = "Verify validation error message for email format",
            dataProvider = "email-format-validation-set-forgot-password", dataProviderClass = PageData.class)
    public void emailValidationMessageTest(String emailData, String expectedValidationMessage) {
        String actualValidationMessage = new SignInPage()
                .open()
                .clickForgotPasswordLink()
                .init()
                .typeEmail(emailData)
                .clickSendButton()
                .getValidationMessage();
        assertEquals(actualValidationMessage, expectedValidationMessage,
                "Incorrect validation message");
    }

}
