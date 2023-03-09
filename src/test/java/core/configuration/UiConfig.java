package core.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config-ui.properties")
public interface UiConfig extends Config {
    String url();
    String browser();
    boolean headless();
    int timeout();
}
