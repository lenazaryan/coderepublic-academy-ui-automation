package com.academy.automation.dataprovider;

import org.testng.annotations.DataProvider;

public class PageData {
    @DataProvider(name = "login-set")
    public Object[][] testData(){
        return new Object[][]{
                {"", ""},
                {"test@gmail.com", "test"},
                {"test@gmail.com", "academy2023"},
                {"vardan.l.grigoryan@gmail.com", "test"},
        };
    }
}
