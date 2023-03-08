package core.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ApplicationConfig extends Config {
    String url();
    String browser();
    boolean headless();
    int timeout();
}
