package com.academy.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PathsPage extends PageBase<PathsPage> {
    static String PAGE_PATH = "/paths";

    @FindBy(css = ".heading-secondary.heading-secondary--pink:nth-child(2)")
    private WebElement sandbox;

    @Override
    public PathsPage open() {
        return openPage();
    }

    @Override
    public PathsPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }
}
