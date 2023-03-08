package core.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:allure.properties")
public interface AllureConfig extends Config {
    @Key("allure.results.directory")
    String resultsDirectory();
}
