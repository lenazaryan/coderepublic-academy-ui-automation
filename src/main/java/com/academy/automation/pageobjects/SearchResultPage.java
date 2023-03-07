package com.academy.automation.pageobjects;

public class SearchResultPage extends PageBase<SearchResultPage> {
    static String PAGE_PATH = "/search";

    @Override
    public SearchResultPage open() {
        return openPage();
    }

    @Override
    public SearchResultPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }

    public String getUrl() {
        return getPageUrl();
    }

    public SearchResultPage clickBack() {
        navigateBack();
        return this;
    }
}
