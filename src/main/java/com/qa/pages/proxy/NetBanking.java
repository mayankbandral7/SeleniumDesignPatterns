package com.qa.pages.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {

    @FindBy(id = "bank")
    WebElement selectBank;

    @FindBy(id = "acc_number")
    WebElement accNumber;

    @FindBy(id = "pin")
    WebElement pinNumber;

    @Override
    public void fillPaymentDetails(Map<String, String> bankDetails) {
        Select select = new Select(selectBank);
        select.selectByValue(bankDetails.get("bankName"));
        accNumber.sendKeys(bankDetails.get("accNumber"));
        pinNumber.sendKeys(bankDetails.get("pinNumber"));
    }
}
