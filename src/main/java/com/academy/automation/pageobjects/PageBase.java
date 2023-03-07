package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import static com.academy.automation.configuration.DriverBase.getDriver;
import static com.academy.automation.helper.Waiter.getWait;

public abstract class PageBase<T> {
    static String BASE_URL = "https://academy-stream.coderepublic.am";

    abstract T open();

    abstract T init();

    abstract String getUrlPath();

    protected void load() {
//        variable = condition ? value_if_condition_true : value_if_condition_false;
        String url = !(getUrlPath() == null) ? BASE_URL + getUrlPath() : BASE_URL;
        getDriver().get(url);
    }

    protected T openPage() {
        load();
        initPage();
        return (T) this;
    }

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        return (T) this;
    }

    protected void clickOn(WebElement element) {
        getWait().waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void clickOn(List<WebElement> elements, int position) {
        clickOn(elements.get(position));
    }

    protected void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void type(List<WebElement> elements, int position, String text) {
        type(elements.get(position), text);
    }

    protected void hover(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    protected void navigateBack() {
        getDriver().navigate().back();
    }

    protected String getPageUrl() {
        getWait().sleep(3000);
        return getDriver().getCurrentUrl();
    }

    protected boolean elementIsDisplayed(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        return element.isDisplayed();
    }

}
