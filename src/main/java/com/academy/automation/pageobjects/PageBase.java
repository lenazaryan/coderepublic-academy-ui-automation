package com.academy.automation.pageobjects;

import com.academy.automation.configuration.DriverBase;
import com.academy.automation.configuration.DriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class PageBase<T> {
    static String BASE_URL = "https://academy-stream.coderepublic.am";

    abstract T open();
    abstract T init();
    abstract String getUrlPath();

    protected void load(){
//        variable = condition ? value_if_condition_true : value_if_condition_false;
//        if(getUrlPath()==null){
//            url = BASE_URL;
//        }else {
//            url = BASE_URL + getUrlPath();
//        }
        String url = !(getUrlPath()==null)? BASE_URL+getUrlPath(): BASE_URL;
        DriverBase.getDriver().get(url);
    }
    protected T openPage(){
        load();
        initPage();
        return (T)this;
    }
    protected T initPage(){
        PageFactory.initElements(DriverBase.getDriver(), this);
        return (T)this;
    }

    protected void clickOn(WebElement element){
        element.click();
    }

    protected void clickOn(List<WebElement> elements, int position){
        clickOn(elements.get(position));
    }

    protected void type(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void type(List<WebElement> elements, int position, String text){
        type(elements.get(position), text);
    }

    protected void hover(WebElement element){
        new Actions(DriverBase.getDriver()).moveToElement(element).build().perform();
    }

    protected void navigateBack(){
        DriverBase.getDriver().navigate().back();
    }

    protected String getPageUrl(){
        return DriverBase.getDriver().getCurrentUrl();
    }


}
