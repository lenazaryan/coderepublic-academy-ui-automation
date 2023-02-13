package com.academy.automation.dataprovider;

import org.testng.annotations.DataProvider;

public class PageData {
    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][]{
                {"",""},
                {"",""}
        };
    }
}
