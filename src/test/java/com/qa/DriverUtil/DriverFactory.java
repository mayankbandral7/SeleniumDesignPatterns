package com.qa.DriverUtil;

import com.qa.constants.BrowserEnums;
import com.qa.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.function.Function;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static final Function<PropertiesUtils, DriverManager> chromeDriverSupplier = ChromeDriverServiceBuilder::new;
    private static final Function<PropertiesUtils, DriverManager> fireFoxDriverSupplier = FireFoxServiceBuilder::new;

    private static final Map<String, Function<PropertiesUtils, DriverManager>> supplierMap =
            Map.of(BrowserEnums.CHROME.getBrowserName(), chromeDriverSupplier, BrowserEnums.FIREFOX.getBrowserName(), fireFoxDriverSupplier);

    public static DriverManager getDriverService(String serviceName, PropertiesUtils propertiesUtils) {
        logger.info("Passed Browser Name is " + serviceName);
        return supplierMap.get(serviceName).apply(propertiesUtils);
    }
}
