package com.qa.pages.executeAround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Consumer;

public class HomePage {

    private final WebDriver driver;
    private final FrameA frameA;
    private final FrameB frameB;
    private final FrameC frameC;

    @FindBy(id = "a")
    private WebElement iframeA;

    @FindBy(id = "b")
    private WebElement iframeB;

    @FindBy(id = "c")
    private WebElement iframeC;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        frameA = PageFactory.initElements(driver, FrameA.class);
        frameB = PageFactory.initElements(driver, FrameB.class);
        frameC = PageFactory.initElements(driver, FrameC.class);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void setFrameA(Consumer<FrameA> switchFrameConsumer) {
        driver.switchTo().frame(iframeA);
        switchFrameConsumer.accept(this.frameA);
        driver.switchTo().defaultContent();
    }

    public void setFrameB(Consumer<FrameB> switchFrameConsumer) {
        driver.switchTo().frame(iframeB);
        switchFrameConsumer.accept(this.frameB);
        driver.switchTo().defaultContent();
    }

    public void setFrameC(Consumer<FrameC> switchFrameConsumer) {
        driver.switchTo().frame(iframeC);
        switchFrameConsumer.accept(this.frameC);
        driver.switchTo().defaultContent();
    }


}
