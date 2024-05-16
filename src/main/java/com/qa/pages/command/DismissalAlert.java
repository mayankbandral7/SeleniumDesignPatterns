package com.qa.pages.command;

import com.google.common.util.concurrent.Uninterruptibles;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DismissalAlert implements CommandPage {
    private final WebElement dismissalAlert;


    public DismissalAlert(WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public Boolean execute() {
        dismissalAlert.click();
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
        Assert.isTrue(!dismissalAlert.isDisplayed(), "Element is visible");
        return true;
    }
}
