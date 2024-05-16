package com.qa.pages.command;

import com.google.common.util.concurrent.Uninterruptibles;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator implements CommandPage {

    private final WebElement alertBtn;
    private final WebElement notificationToast;

    public NotificationValidator(WebElement alertBtn, WebElement notificationToast) {
        this.alertBtn = alertBtn;
        this.notificationToast = notificationToast;
    }

    @Override
    public Boolean execute() {
        this.alertBtn.click();
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
        Assert.isTrue(notificationToast.isDisplayed(), alertBtn + " is Not Visible");
        return true;
    }
}
