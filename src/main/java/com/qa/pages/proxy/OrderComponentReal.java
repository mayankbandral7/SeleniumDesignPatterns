package com.qa.pages.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal {
    private final WebDriver driver;

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderComponentReal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getOrderNumber() {
        buy.click();
        return orderNumber.getText();
    }

}
