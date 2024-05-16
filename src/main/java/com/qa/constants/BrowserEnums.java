package com.qa.constants;


public enum BrowserEnums {

    CHROME("chrome"), FIREFOX("firefox");

    private final String browserName;

    BrowserEnums(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
}
