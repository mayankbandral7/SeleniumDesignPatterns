package com.qa.DriverUtil;

import com.qa.constants.FilePaths;
import com.qa.utils.PropertiesUtils;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FireFoxServiceBuilder extends DriverManager {
    private final Path fireFoxLogPath = Paths.get(FilePaths.FIREFOX_DRIVER_LOG_PATH);
    private final Boolean isGridEnabled;
    private final String hub;

    public FireFoxServiceBuilder(PropertiesUtils propertiesUtils) {
        this.isGridEnabled = Boolean.getBoolean(propertiesUtils.gridEnabled());
        this.hub = propertiesUtils.hub();
    }

    @Override
    public void createDriver() {
        try {
            FirefoxDriverService firefoxDriverService = new GeckoDriverService.Builder()
                    .usingAnyFreePort().withLogLevel(FirefoxDriverLogLevel.DEBUG)
                    //.withLogFile(new File(fireFoxLogPath.toString()))
                    .build();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = isGridEnabled ? new RemoteWebDriver(new URL("http://" + hub + ":4444"), firefoxOptions) :
                    new FirefoxDriver(firefoxDriverService, firefoxOptions.setBrowserVersion("124"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
