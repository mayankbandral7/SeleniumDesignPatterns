package com.qa.pages.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {
    private WebDriver driver;
    private Order order;
    private PaymentOption paymentOption;

    @FindBy(id = "fn")
    WebElement firstName;

    @FindBy(id = "ln")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;


    public PaymentScreen(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        order = PageFactory.initElements(driver, Order.class);
    }

    public void userDetails(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void fillPaymentFields(Map<String,String> paymentDetails) {
        paymentOption.fillPaymentDetails(paymentDetails);
    }

    public String getOrder() {
        return order.getOrderNumber();
    }
}
