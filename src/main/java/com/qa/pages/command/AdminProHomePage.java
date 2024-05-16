package com.qa.pages.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AdminProHomePage {

    private WebDriver driver;

    //buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-warning")
    private WebElement dismissWarnAlert;

    public AdminProHomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<CommandPage> returnValidators() {
        return List.of(
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                new DismissalAlert(dismissInfoAlert),
                new DismissalAlert(dismissWarnAlert),
                new DismissalAlert(dismissSuccessAlert),
                new DismissalAlert(dismissDangerAlert)
        );
    }


}
