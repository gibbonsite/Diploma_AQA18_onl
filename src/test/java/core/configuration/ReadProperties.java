package core.configuration;

import org.aeonbits.owner.ConfigFactory;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final ApplicationConfig config = ConfigFactory.create(ApplicationConfig.class);

    public static ApplicationConfig getConfig() {
        return config;
    }
}
