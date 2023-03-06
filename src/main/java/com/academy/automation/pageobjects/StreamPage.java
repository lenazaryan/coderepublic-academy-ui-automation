package com.academy.automation.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Struct;

public class StreamPage extends PageBase<StreamPage> {

    @FindBy(xpath = "//div[@class='firstChild']//div[@class='main-playlists']")
    private WebElement playlists;

    @FindBy(css = ".user_icon")
    private WebElement userIcon;

    @FindBy(css = ".notification_icon")
    private WebElement notificationIcon;

    @FindBy(css = ".header-search")
    private WebElement headerSearchField;

    @FindBy(css = "button[type='submit']")
    private WebElement headerSearchSubmitBtn;

    @Override
    public StreamPage open() {
        return openPage();
    }

    @Override
    public StreamPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return null;
    }

    public boolean userIconIsDisplayed() {
        return userIcon.isDisplayed();
    }

    public String getUrl() {
        return getPageUrl();
    }

    public StreamPage hoverHeaderSearchField() {
        hover(headerSearchField);
        return this;
    }

    public StreamPage clickHeaderSearchField() {
        clickOn(headerSearchField);
        return this;
    }

    public StreamPage typeInSearchField(String text){
        type(headerSearchField, text);
        return this;
    }

    public String getValueOfSearchField(){
        return headerSearchField.getAttribute("value");
    }

    public StreamPage clickHeaderSearchSubmitButton() {
        clickOn(headerSearchSubmitBtn);
        return this;
    }

}
