package com.academy.automation.pageobjects;

import com.academy.automation.configuration.DriverBase;
import com.academy.automation.configuration.DriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageBase {
    PageBase(){
        PageFactory.initElements(DriverBase.getDriver(), this);
    }

    protected void clickOn(WebElement element){
        element.click();
    }

    protected void clickOn(List<WebElement> elements, int position){
//        elements.get(position).click();
        clickOn(elements.get(position)); //THEY ARE THE SAME
    }

    protected void type(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void type(List<WebElement> elements, int position, String text){
//        elements.get(position).sendKeys(text);
        type(elements.get(position), text); //THEY WORK IN THE SAME WAY
    }


}
