package com.academy.automation.dataprovider;

import org.testng.annotations.DataProvider;

public class PageData {
    @DataProvider(name = "login-set")
    public Object[][] testData(){
        return new Object[][]{
                {"", ""},
                {"test@gmail.com", "academy2023"},
                {"test", "academy2023"},
                {"vardan.l.grigoryan@gmail.com", "test"},
                {"vardan.l.grigoryan@gmail.com", "academy2023"}
        };
    }
}
