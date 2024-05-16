package com.qa.pages.executeAround;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class FrameA {

    @FindBy(name = "fn")
    WebElement firstName;

    @FindBy(name = "ln")
    WebElement lastName;

    @FindBy(name = "addr")
    WebElement addressName;

    public void fillUserDetails(Map<String, String> userDetails) {
        firstName.sendKeys(userDetails.get("firstName"));
        lastName.sendKeys(userDetails.get("lastName"));
        addressName.sendKeys(userDetails.get("address"));
    }
}
