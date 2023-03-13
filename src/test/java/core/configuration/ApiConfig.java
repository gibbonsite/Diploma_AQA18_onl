package core.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config-api.properties")
public interface ApiConfig extends Config {
    String token();
    String dbType();
    String dbHost();
    String dbPort();
    String dbName();
}
