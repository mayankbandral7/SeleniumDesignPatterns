package com.qa.pages.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCard implements PaymentOption {

    @FindBy(id = "cc")
    WebElement creditCard;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(id = "cvv")
    WebElement cvv;

    @Override
    public void fillPaymentDetails(Map<String, String> cardDetails) {
        this.creditCard.sendKeys(cardDetails.get("creditCardNumber"));
        this.year.sendKeys(cardDetails.get("year"));
        this.cvv.sendKeys(cardDetails.get("cvv"));
    }
}
