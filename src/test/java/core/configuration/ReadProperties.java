package core.configuration;

import org.aeonbits.owner.ConfigFactory;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final ApplicationConfig config = ConfigFactory.create(ApplicationConfig.class);
    private static final AllureConfig allureConfig = ConfigFactory.create(AllureConfig.class);

    public static ApplicationConfig getConfig() {
        return config;
    }

    public static AllureConfig getAllureConfig() {
        return allureConfig;
    }
}
