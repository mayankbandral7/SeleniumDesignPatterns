package com.qa.utils;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigManager {

    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);

    public PropertiesUtils getPropertiesUtils() {
        logger.info("config manager");
        return ConfigFactory.create(PropertiesUtils.class);
    }


}
