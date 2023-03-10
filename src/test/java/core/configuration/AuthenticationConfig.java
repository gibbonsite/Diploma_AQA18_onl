package core.configuration;

import org.aeonbits.owner.Config;

public interface AuthenticationConfig extends Config {
    @Key("github_username")
    String gitHubUsername();
    @Key("github_password")
    String gitHubPassword();
    @Key("db_username")
    String dbUsername();
    @Key("db_password")
    String dbPassword();
}
