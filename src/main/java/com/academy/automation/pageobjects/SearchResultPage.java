package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

    @FindBy(css = ".video-search")
    private WebElement searchResultContainer;
}
