package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StreamPage extends PageBase{

    @FindBy(xpath = "//div[@class='firstChild']//div[@class='main-playlists']")
    private WebElement playlists;

    @FindBy(css = ".user_icon")
    private WebElement userIcon;

    @FindBy(css = ".notification_icon")
    private WebElement notificationIcon;

    public boolean userIconIsDisplayed(){
        return userIcon.isDisplayed();
    }
}
