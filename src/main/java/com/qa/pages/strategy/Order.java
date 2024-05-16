package com.qa.pages.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {
    private final WebDriver driver;

    @FindBy(id = "buy")
    WebElement buy;

    @FindBy(id = "ordernumber")
    WebElement orderNumber;

    public Order(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getOrderNumber() {
        buy.click();
        return orderNumber.getText();
    }

}
