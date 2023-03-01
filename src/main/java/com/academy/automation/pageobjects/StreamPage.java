package com.academy.automation.pageobjects;

import com.academy.automation.utils.Actions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StreamPage extends PageBase<StreamPage>{

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

    public boolean userIconIsDisplayed(){
        return userIcon.isDisplayed();
    }

    public String getUrl(){return Actions.getPageUrl();}

    public StreamPage hoverHeaderSearchField(){
        Actions.hover(headerSearchField);
        return this;
    }
    public String getCssValueOfSearchField(String value){
        return headerSearchField.getCssValue(value);
    }
    public boolean headerSearchFieldIsClicked(){
        try{
            clickOn(headerSearchField);
        }catch(StaleElementReferenceException e){
            return false;
        }
        return true;
    }
    public StreamPage typeInSearchField(String text){
        type(headerSearchField, text);
        return this;
    }

    public StreamPage clickHeaderSearchSubmitButton(){
        clickOn(headerSearchSubmitBtn);
        return this;
    }

}
