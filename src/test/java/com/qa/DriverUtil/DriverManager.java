package com.qa.DriverUtil;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public abstract class DriverManager {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    protected WebDriver driver;

    abstract void createDriver();

    WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            logger.info("Inside get driver method");
            createDriver();
        }
        logger.info("Returning driver");
        return driver;
    }

    public void quitDriver() {
        if (Objects.isNull(driver)) {
            logger.error("Driver is already null; cannot kill it !!");
            throw new RuntimeException("Driver is in null State!!");
        }
        driver.quit();
        logger.info("Driver Killed !!");
    }
}
