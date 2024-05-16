package com.qa.DriverUtil;

import com.qa.utils.ConfigManager;
import com.qa.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;
    protected PropertiesUtils propertiesUtils;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() {
        logger.info("Inside base test");
        propertiesUtils = new ConfigManager().getPropertiesUtils();
        String browserName = propertiesUtils.browser();
        logger.info("Browser Name from system properties: " + browserName);
        driverManager = DriverFactory.getDriverService(browserName, propertiesUtils);
        driver = driverManager.getDriver();
        logger.info("Driver Instantiated : " + driver.manage().toString());
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        logger.info("Inside After Test");
        driverManager.quitDriver();
    }
}
