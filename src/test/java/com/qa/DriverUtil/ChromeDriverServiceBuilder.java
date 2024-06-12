package com.qa.DriverUtil;

import com.qa.constants.FilePaths;
import com.qa.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ChromeDriverServiceBuilder extends DriverManager {
    private final Path chromeDriverLogPath = Paths.get(FilePaths.CHROME_DRIVER_LOG_PATH);
    private final Boolean isGridEnabled;
    private final String hub;
    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverServiceBuilder.class);

    public ChromeDriverServiceBuilder(PropertiesUtils propertiesUtils) {
        this.isGridEnabled = Boolean.parseBoolean(propertiesUtils.gridEnabled());
        logger.debug("Is Grid enabled " + this.isGridEnabled);
        this.hub = propertiesUtils.hub();
        logger.debug("Hub Host is " + this.hub);
    }

    @Override
    public void createDriver() {
        try {
            logger.debug("Inside ChromeDriverServiceBuilder class; driver is null, Creating it !!");
            ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                    .usingAnyFreePort()
                    .withLogLevel(ChromiumDriverLogLevel.ALL)
                    .withReadableTimestamp(true)
                    //.withLogFile(new File(chromeDriverLogPath.toString()))
                    .build();
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setBrowserVersion("120");
            chromeOptions.setAcceptInsecureCerts(true);

            driver = isGridEnabled ? new RemoteWebDriver(new URL("http://" + hub + ":4444"), chromeOptions) :
                    new ChromeDriver(chromeDriverService, chromeOptions);
        } catch (Exception e) {
            logger.error("Couldn't Initialise Chrome Browser!!! Abort");
            e.printStackTrace();
        }
    }
}
