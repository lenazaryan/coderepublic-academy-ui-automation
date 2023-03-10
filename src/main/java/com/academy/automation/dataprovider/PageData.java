package com.academy.automation.dataprovider;

import org.testng.annotations.DataProvider;

public class PageData {
    @DataProvider(name = "invalid-email-password-data")
    public Object[][] invalidEmailPasswordData() {
        return new Object[][]{
                {"", "", "Required", "Required"},

                {"test", "test", "Invalid email address", "password must be at least 8 characters"},

                {"test@test", "Abcdfgehj./,", "Invalid email address",
                        "Password should contain minimum 8 characters, at least one letter and one number"},

                {"test@test.", "      a1", "Invalid email address",
                        "Password should contain minimum 8 characters, at least one letter and one number"},

                {" @gmail.com", "12345678", "Invalid email address",
                        "Password should contain minimum 8 characters, at least one letter and one number"},
        };
    }

    @DataProvider(name = "incorrect-email-password-set")
    public Object[][] incorrectEmailPasswordSet() {
        return new Object[][]{
                {"test@test.com", "test1234"},
                {"vardan.l.grigoryan@gmail.com", "test1234"},
                {"test@test.com", "academy2023"},
        };
    }

    @DataProvider(name = "correct-incorrect-email-set-for-forgot-password")
    public Object[][] correctIncorrectEmailSetForForgotPassword() {
        return new Object[][]{
                {"", "Something went wrong"},
                {"test@test", "Something went wrong"},
                {"azaryanlena@gmail.com", "Something went wrong"},
                {"vardan.l.grigoryan@gmail.com", "Email sent. Please check your email to reset your password"},
        };
    }

    @DataProvider(name = "email-format-validation-set-forgot-password")
    public Object[][] emailFormatValidationSetForgotPassword() {
        return new Object[][]{
                {"test", "Please include an '@' in the email address. 'test' is missing an '@'."},
                {"@gmail.com", "Please enter a part followed by '@'. '@gmail.com' is incomplete."},
                {"test@", "Please enter a part following '@'. 'test@' is incomplete."},
                {"test@.", "'.' is used at a wrong position in '.'."},
                {"test@.com", "'.' is used at a wrong position in '.com'."},
        };
    }
}
