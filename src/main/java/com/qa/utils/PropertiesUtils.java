package com.qa.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:test.properties", "system:properties"})
public interface PropertiesUtils extends Config {

    String projectName();

    @DefaultValue("firefox")
    String browser();

    @Key("system.grid.enabled")
    @DefaultValue("false")
    String gridEnabled();

    @DefaultValue("localhost")
    @Key("system.grid.hub")
    String hub();
}
