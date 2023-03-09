package core.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config-api.properties")
public interface ApiConfig extends Config {
    String username();
    String password();
    String url();
    String token();
    String database();
}
