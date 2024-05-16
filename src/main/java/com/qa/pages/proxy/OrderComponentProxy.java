package com.qa.pages.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class OrderComponentProxy {
    OrderComponentReal orderComponent;

    public OrderComponentProxy(WebDriver driver) {
        System.setProperty("env", "Prod");
        if (System.getProperty("env").equals("QA")) {
            System.out.println("Inside order Component Proxy");
            orderComponent = new OrderComponentReal(driver);
        }
    }

    public String getOrder() {
        if (Objects.nonNull(orderComponent)) {
            return orderComponent.getOrderNumber();
        }
        return "SKIPPED";
    }
}
